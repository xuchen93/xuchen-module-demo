package com.github.xuchen93;

import cn.hutool.json.JSONUtil;
import com.github.xuchen93.database.table.entity.SysUser;
import com.github.xuchen93.database.table.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DatabaseDemoApplicationTests {


	@Autowired
	SysUserService sysUserService;

	@Test
	void contextLoads() {
		List<SysUser> list = sysUserService.list();
		System.out.println(JSONUtil.toJsonPrettyStr(list));
	}

}
