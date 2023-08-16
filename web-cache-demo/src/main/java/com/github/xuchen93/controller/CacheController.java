package com.github.xuchen93.controller;

import com.github.xuchen93.model.R;
import com.github.xuchen93.model.CacheModel;
import com.github.xuchen93.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author edwin
 */
@Slf4j
@Controller
@ResponseBody
public class CacheController {

	@Autowired
	CacheService cacheService;

	@GetMapping("getEntity")
	public R getEntity(Integer id) {
		CacheModel entity = cacheService.getEntity(id);
		return R.success(entity);
	}
}
