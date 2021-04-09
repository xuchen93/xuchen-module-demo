package com.github.xuchen93.controller;

import com.github.xuchen93.model.R;
import com.github.xuchen93.model.TestModel;
import com.github.xuchen93.web.controller.BaseController;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author edwin
 */
@Slf4j
@RestController
public class TestController extends BaseController {


	@GetMapping("test")
	public R test() {
		return R.success(LocalDateTime.now().toString());
	}

	@SneakyThrows
	@PostMapping("post")
	public R post(TestModel model) {
		return R.success(LocalDateTime.now().toString());
	}
}
