package com.github.xuchen93.controller;

import com.github.xuchen93.model.R;
import com.github.xuchen93.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author edwin
 */
@Slf4j
@RestController
public class TestController {

	@Autowired
	private TestService testService;

	@GetMapping("test")
	public R test() {
		testService.async();
		return R.success(LocalDateTime.now().toString());
	}
}
