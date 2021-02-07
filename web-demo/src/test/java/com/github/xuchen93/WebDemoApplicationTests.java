package com.github.xuchen93;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.github.xuchen93.core.util.RedisStore;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.redis.util.RedisLockRegistry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@Slf4j
@SpringBootTest
class WebDemoApplicationTests {


	@SneakyThrows
	@Test
	void contextLoads() {
		RedisLockRegistry registry = SpringUtil.getBean(RedisLockRegistry.class);
		Lock lock = registry.obtain("testKey");
		boolean tryLock = lock.tryLock(20, TimeUnit.SECONDS);
		System.out.println(Thread.currentThread().getId() + "---" +Thread.currentThread().getName());
		System.out.println(lock);
		log.info("第一次获取"+tryLock);
		ExecutorService executor = ThreadUtil.newExecutor(5);
		for (int i = 0; i < 30; i++) {
			executor.execute(()->{
				Lock newLock = registry.obtain("testKey");
				boolean newLockR = false;
				try {
					newLockR = newLock.tryLock(3, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getId() + "---" +Thread.currentThread().getName());
				System.out.println(newLock);
				log.info("之后获取"+newLockR);
			});
			ThreadUtil.sleep(1,TimeUnit.SECONDS);
		}
		executor.shutdown();
		ThreadUtil.sync(this);
	}

}
