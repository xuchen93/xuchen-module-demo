package com.github.xuchen93.service;

import cn.hutool.json.JSONUtil;
import com.github.xuchen93.bean.RequestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author edwin
 */
@Slf4j
@Service
public class TestService {

	@Autowired
	private RequestBean requestBean;

	@Autowired
	private ApplicationContext applicationContext;

	@Async
	public void async() {
		log.info(applicationContext.toString());
		AnnotationConfigServletWebServerApplicationContext context = (AnnotationConfigServletWebServerApplicationContext) applicationContext;
		context.registerBean("singleBean", RequestBean.class);
		log.info(JSONUtil.toJsonStr(requestBean));
		RequestBean bean = context.getBean(RequestBean.class);
		log.info(JSONUtil.toJsonStr(bean));
	}
}
