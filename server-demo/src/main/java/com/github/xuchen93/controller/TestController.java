package com.github.xuchen93.controller;

import com.github.xuchen93.model.R;
import com.github.xuchen93.web.annotation.RedisLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author edwin
 */
@RestController
public class TestController {

	@GetMapping("test")
	@RedisLimit(period = 10, timeunit = TimeUnit.MINUTES, count = 2)
	public R test() {
		return R.success();
	}
}
