package com.github.xuchen93.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Aware注解表示感知，如BeanNameAware可以感知到beanName被赋值
 * @author xuchen.wang
 * @date 2022/7/19
 */
@Slf4j
@Component
public class TestAware implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		log.info("setBeanFactory");
		log.info(beanFactory.toString());
	}

	@Override
	public void setBeanName(String name) {
		log.info("setBeanName");
		log.info(name.toString());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.info("setApplicationContext");
		log.info(applicationContext.toString());
	}
}
