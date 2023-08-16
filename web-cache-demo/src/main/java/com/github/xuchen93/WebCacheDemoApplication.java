package com.github.xuchen93;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Arrays;

@Slf4j
@EnableCaching
@SpringBootApplication
public class WebCacheDemoApplication implements BeanFactoryPostProcessor {

	public static void main(String[] args) {
		SpringApplication.run(WebCacheDemoApplication.class, args);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.info("--------------");
		String[] definitionNames = beanFactory.getBeanDefinitionNames();
		Arrays.stream(definitionNames).filter(i -> i.contains("Cache") || i.contains("cache")).forEach(d -> {
			System.out.println(d);
		});
		System.out.println("------------");
	}
}
