package com.github.xuchen93.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author xuchen.wang
 * @date 2022/4/15
 */
@Slf4j
//@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

	@Nullable
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		log.error(beanName);
		return bean;
	}
}
