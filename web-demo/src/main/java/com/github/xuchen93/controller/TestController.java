package com.github.xuchen93.controller;

import cn.hutool.json.JSONUtil;
import com.github.xuchen93.model.R;
import com.github.xuchen93.model.TestModel;
import com.github.xuchen93.web.controller.BaseController;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author edwin
 */
@Slf4j
@Controller
@ResponseBody
public class TestController extends BaseController {


	@GetMapping("test")
	public R test11() {
		ThreadLocal threadLocal = new ThreadLocal();
		threadLocal.set("key");
		threadLocal.remove();
		return R.success(LocalDateTime.now().toString());
	}

	@SneakyThrows
	@PostMapping("post")
	public R post111(TestModel model) {
		log.info(JSONUtil.toJsonStr(model));
		return R.success(LocalDateTime.now().toString());
	}

	@PostMapping("post/list1")
	public R postList(ArrayList<TestModel> list) {
		return R.success(JSONUtil.toJsonStr(list));
	}

	@PostMapping("post/list2")
	public R postList2(List<TestModel> list) {
		return R.success(JSONUtil.toJsonStr(list));
	}

	@PostMapping("post/list3")
	public R postList3(@RequestBody List<TestModel> list,TestModel model) {
		log.info(model.toString());
		return R.success(JSONUtil.toJsonStr(list));
	}
}
