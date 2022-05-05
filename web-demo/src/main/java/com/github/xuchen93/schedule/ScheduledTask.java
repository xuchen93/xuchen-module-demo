package com.github.xuchen93.schedule;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xuchen.wang
 * @date 2022/4/15
 */
@Slf4j
@Component
public class ScheduledTask {

	@PostConstruct
	public void init(){
		log.info("init");
	}

	@Scheduled(cron = "0/2 * * * * ?")
	private void task() {
		ThreadUtil.sleep(2000);
		log.info("execute task");
	}

	@Scheduled(cron = "0/2 * * * * ?")
	private void task2() {
		ThreadUtil.sleep(3000);
		log.info("execute task2");
	}
}
