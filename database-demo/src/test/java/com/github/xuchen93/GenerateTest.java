package com.github.xuchen93;

import cn.hutool.core.collection.CollUtil;
import com.github.xuchen93.generate.model.GenerateInfo;
import com.github.xuchen93.generate.service.GenerateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenerateTest {

	@Autowired
	GenerateService generateService;

	@Test
	void contextLoads() {
		generateService.generate(new GenerateInfo() {{
			setTableList(CollUtil.newArrayList("xdsqthm"));
			setPackageName("com.github.xuchen93.database.table");
		}});
	}

}
