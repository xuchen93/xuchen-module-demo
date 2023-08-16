package com.github.xuchen93.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;

/**
 * @author Edwin
 * @date 2019/01/14
 */
@Slf4j
@Data
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestBean {
	private String userName;
	private LocalDateTime dateTime = LocalDateTime.now();


	@PostConstruct
	public void init() {
		log.info("创建对象");
	}

	@PreDestroy
	public void destroy() {
		log.info("销毁对象");
	}
}
