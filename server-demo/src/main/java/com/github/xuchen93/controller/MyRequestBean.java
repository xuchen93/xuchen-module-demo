package com.github.xuchen93.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author edwin
 */
@Slf4j
@Component
@Scope(value = "threadLocalScope", proxyMode = ScopedProxyMode.TARGET_CLASS)
//@RequestScope
public class MyRequestBean {
	public MyRequestBean() {
		log.info("构造方法");
	}

	@PostConstruct
	public void postConstruct(){
		log.info("postConstruct");
	}

	@PreDestroy
	public void preDestroy(){
		log.info("preDestroy");
	}
}
