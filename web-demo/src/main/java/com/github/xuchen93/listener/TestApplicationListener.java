package com.github.xuchen93.listener;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xuchen.wang
 * @date 2022/5/26
 */
@Slf4j
//@Component
public class TestApplicationListener implements ApplicationListener<ApplicationEvent> {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		log.error(event.getClass().toString());
		log.error("接收到事件：{}", event.toString());
	}
}
