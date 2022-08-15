package com.github.xuchen93;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.github.xuchen93.controller.TestController;
import com.github.xuchen93.core.util.RedisStore;
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

		RedisStore.setValue("testK","testV1");
	}
}
