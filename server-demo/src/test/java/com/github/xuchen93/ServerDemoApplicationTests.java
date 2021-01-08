package com.github.xuchen93;

import cn.hutool.json.JSONUtil;
import com.github.xuchen93.database.table.entity.SysUser;
import com.github.xuchen93.database.table.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class ServerDemoApplicationTests {

	@Autowired
	SysUserService sysUserService;

	@Test
	void contextLoads() {
		List<SysUser> userList = sysUserService.list();
		log.info(String.valueOf(userList.size()));
		log.info(JSONUtil.toJsonPrettyStr(userList));

	}

}
