package com.github.xuchen93.schedule;

import com.github.xuchen93.model.ex.BusiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author xuchen.wang
 * @date 2022/4/15
 */
@Slf4j
@Component("scheduledTask")
public class ScheduledTask {

	public ScheduledTask() {
		log.info("创建ScheduledTask");
	}

	@PostConstruct
	public void init(){
		log.info("init");
	}
//
	@Scheduled(cron = "0/5 * * * * ?")
	private void task() {
		log.info("execute task");
//		throw new BusiException("scheduled error");
	}

	@Scheduled(cron = "3/5 * * * * ?")
	private void task2() {
		log.info("execute task2");
	}
}
