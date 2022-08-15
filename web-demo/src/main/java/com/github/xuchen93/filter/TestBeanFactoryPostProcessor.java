package com.github.xuchen93.filter;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.context.support.StandardServletEnvironment;

/**
 * beanDefinition生成之后，生成bean之前的拦截器
 * 这个时候可以修改beanDefinition，影响到bean的属性
 * @author xuchen.wang
 * @date 2022/4/15
 */
@Slf4j
//@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
		StandardServletEnvironment environment = factory.getBean(StandardServletEnvironment.class);
		log.error(JSONUtil.toJsonStr(environment));
		String[] beanDefinitionNames = factory.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			log.warn("beanDefinitionName:{}",beanDefinitionName);
			log.warn("beanDefinition:{}",JSONUtil.toJsonStr(factory.getBeanDefinition(beanDefinitionName)));
		}
	}
}
