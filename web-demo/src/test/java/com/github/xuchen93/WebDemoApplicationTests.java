package com.github.xuchen93;

import cn.hutool.core.thread.ThreadUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
@SpringBootTest
class WebDemoApplicationTests {

	@SneakyThrows
	@Test
	void contextLoads() {
		ThreadUtil.sleep(100000);
		log.info("test method");
	}
}
