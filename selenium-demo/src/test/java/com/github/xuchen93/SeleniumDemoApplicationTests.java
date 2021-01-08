package com.github.xuchen93;

import com.github.xuchen93.selenium.service.base.BaseSeleniumService;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SeleniumDemoApplicationTests {

	@Autowired
	BaseSeleniumService baseSeleniumService;

	@Test
	void contextLoads() {
		RemoteWebDriver webDriver = baseSeleniumService.getDriver();
		webDriver.get("https://segmentfault.com/");
		//抓取页面文章标题示例
		List<WebElement> list = webDriver.findElementsByXPath("//div[@class='news-list']//h4");
		list.forEach(item -> System.out.println(item.getText()));
	}

}
