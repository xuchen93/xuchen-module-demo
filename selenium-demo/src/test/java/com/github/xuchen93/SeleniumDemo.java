package com.github.xuchen93;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xuchen.wang
 * @date 2022/6/2
 */
@Slf4j
public class SeleniumDemo {
	private static final Logger logger = LoggerFactory.getLogger(SeleniumDemo.class);


	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\software\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("disable-plugins");
		options.addArguments("blink-settings=imagesEnabled=false");
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		ChromeDriver driver = new ChromeDriver(options);

		List<Company> companyList = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			List<Company> companies = getCompanyList(driver, "保温杯", i);
			log.info("第[{}]页合计:{}条",i,companies.size());
			for (Company company : companies) {
				log.info(JSONUtil.toJsonPrettyStr(company));
				getPhone(driver,company);
				log.info(JSONUtil.toJsonPrettyStr(company));
				ThreadUtil.sleep(1000);
			}
			companyList.addAll(companies);
		}
		log.info(JSONUtil.toJsonStr(companyList));
		ExcelUtil.getWriter("D:/1.xlsx").write(companyList).flush();
		driver.close();
	}

	private static List<Company> getCompanyList(ChromeDriver driver, String keyWord, int page){
		driver.get("https://s.1688.com/selloffer/offer_search.htm?keywords="+ URLUtil.encode(keyWord, CharsetUtil.CHARSET_GBK)+"&spm=a26352%2C13672862&beginPage="+page+"#sm-filtbar");
		List<WebElement> list = driver.findElementsByXPath("//ul[@id='sm-offer-list']//div[@class='mojar-element-company']/div[@class='company-name']");
		List<Company> companyList = list.stream().map(i -> {
			Company company = new Company();
			company.setName(i.getAttribute("title"));
			company.setUrl(i.findElement(new By.ByXPath("a")).getAttribute("href"));
			return company;
		}).collect(Collectors.toList());
		return companyList;
	}

	private static void getPhone(ChromeDriver driver,Company company){
		driver.get(company.getUrl());
		String pageSource = driver.getPageSource();
		List<String> regList = ReUtil.findAllGroup0("^1[3456789]\\d{9}\r\n", pageSource);
		regList = regList.stream().map(i->i.replace("\r\n","")).collect(Collectors.toList());
		List<String> length8List = ReUtil.findAllGroup0("\\d{2} \\d{4} \\d{6,}", pageSource);
		regList.addAll(length8List);
		company.setPhoneSet(new HashSet<>(regList));
		List<WebElement> elements;
		log.info("获取联系方式模块");
		try {
			elements = driver.findElementsByXPath("//div[contains(@class,'app-contactSmall')]//dl");
		}catch (Exception e){
			logger.error("获取联系方式失败：{}-{}",company.getName(),company.getUrl());
			logger.error("获取联系方式失败",e);
			return;
		}
		log.info("解析移动电话");
		try {
			WebElement mobileElement  = elements.stream().filter(i -> "m-mobilephone".equals(i.getAttribute("class"))).findFirst().get();
			company.setPhone(mobileElement.getAttribute("data-no"));
		}catch (Exception e){
			logger.error("解析移动电话失败：{}-{}",company.getName(),company.getUrl());
			logger.error("解析移动电话失败",e);
		}
		log.info("解析电话");
		try {
			WebElement phoneElement = elements.stream().filter(i -> i.getText().contains("电      话：")).findFirst().get();
			company.setPhone2(phoneElement.getText().replace("电      话：\n",""));
		}catch (Exception e){
			logger.error("解析电话失败：{}-{}",company.getName(),company.getUrl());
			logger.error("解析电话失败",e);
		}
	}

	@Data
	public static class Company{
		private String name;
		private String url;
		private String phone;
		private String phone2;
		private Set<String> phoneSet;
	}

}
