package com.github.xuchen93.model;

import cn.hutool.json.JSONUtil;

/**
 * @author edwin
 */
public class TestModel {
	private String name;

	public TestModel() {
		System.out.println(this);
		System.out.println(JSONUtil.toJsonStr(this));
	}
}
