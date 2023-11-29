package com.github.xuchen93.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.github.xuchen93.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author edwin
 */
@Slf4j
@RestController
public class TestController {

	@GetMapping("test")
	public R test() {
		return R.success(LocalDateTime.now().toString());
	}

	@PostMapping("hello")
	public String hello(@RequestBody String s) {
		System.out.println(s);
		ThreadUtil.sleep(Integer.parseInt(s)*1000);
		return s;
	}
}
