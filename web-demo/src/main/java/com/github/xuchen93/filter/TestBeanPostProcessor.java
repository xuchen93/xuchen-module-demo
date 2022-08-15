package com.github.xuchen93.filter;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * bean生成的后置处理，可以看到有哪些bean生成和bean生成之后的属性
 * @author xuchen.wang
 * @date 2022/4/15
 */
@Slf4j
//@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

	@Nullable
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.error("{}:{}",beanName, JSONUtil.toJsonStr(bean));
		return bean;
	}
}
