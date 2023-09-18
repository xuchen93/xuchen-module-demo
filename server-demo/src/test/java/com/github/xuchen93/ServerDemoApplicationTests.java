package com.github.xuchen93;

import cn.hutool.json.JSONUtil;
import com.github.xuchen93.database.table.entity.SysUser;
import com.github.xuchen93.database.table.service.SysUserService;
import com.github.xuchen93.mapper.MyTestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class ServerDemoApplicationTests {

	@Autowired
	SysUserService sysUserService;
	@Autowired
	MyTestMapper myTestMapper;

	@Test
	void contextLoads() {
		System.out.println(JSONUtil.toJsonPrettyStr(myTestMapper.getById(5L)));
		System.out.println(JSONUtil.toJsonPrettyStr(myTestMapper.getList()));
	}

}
