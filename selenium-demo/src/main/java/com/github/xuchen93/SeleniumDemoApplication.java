package com.github.xuchen93;

import com.github.xuchen93.selenium.config.ChromeSeleniumConfig;
import com.github.xuchen93.selenium.service.SeleniumChromeServiceImpl;
import com.github.xuchen93.selenium.service.base.BaseSeleniumService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class SeleniumDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumDemoApplication.class, args);
	}

	@Bean
	BaseSeleniumService baseSeleniumService(ChromeSeleniumConfig chromeSeleniumConfig) {
		return new SeleniumChromeServiceImpl(chromeSeleniumConfig);
	}

}
