package com.github.xuchen93.filter;

import cn.hutool.json.JSONUtil;
import com.github.xuchen93.core.config.XuchenProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.StandardServletEnvironment;

import java.util.Arrays;

/**
 * @author xuchen.wang
 * @date 2022/4/15
 */
@Slf4j
//@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
		factory.removeBeanDefinition("scheduledTask");
		XuchenProperties properties = factory.getBean(XuchenProperties.class);
		log.error(JSONUtil.toJsonStr(properties));
		StandardServletEnvironment environment = factory.getBean(StandardServletEnvironment.class);
		log.error(JSONUtil.toJsonStr(environment));
	}
}
