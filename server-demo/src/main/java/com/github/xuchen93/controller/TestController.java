package com.github.xuchen93.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.github.xuchen93.model.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author edwin
 */
@RestController
public class TestController {

	@Autowired
	MyRequestBean bean;

	@GetMapping("test")
	public R test() {
		ApplicationContext applicationContext = SpringUtil.getApplicationContext();

		System.out.println(bean);
		return R.success();
	}

	@GetMapping("test2")
	public R test2() {
		return R.success();
	}


	@GetMapping("test3")
	public R test3() {
		return R.success();
	}
}
