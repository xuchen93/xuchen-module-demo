package com.github.xuchen93;

import com.github.xuchen93.core.util.RedisStore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebDemoApplicationTests {


	@Test
	void contextLoads() {
		Double d = 1.1123;
		RedisStore.delKey("testDouble");
		RedisStore.setValue("testDouble", d);

		Object value = RedisStore.getValue("testDouble");
		System.out.println(value);
		System.out.println(value.getClass());
	}

}
