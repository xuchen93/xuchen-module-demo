package com.github.xuchen93;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableAsync
@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class WebDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebDemoApplication.class, args);
	}

}
