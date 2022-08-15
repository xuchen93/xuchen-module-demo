package com.github.xuchen93;

import cn.hutool.json.JSONUtil;
import com.github.xuchen93.model.leetcode.TreeNode;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author edwin
 */
public class Demo {

	public static void main(String[] args) {
		ThreadLocal l = new ThreadLocal();
		l.set(1);
	}

	@Data
	private static class User{
		private String name;
		private Date birthday;
	}
}
