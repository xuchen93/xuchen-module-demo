package com.github.xuchen93;

import cn.hutool.http.HttpResponse;
import com.github.xuchen93.web.common.HttpPackUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author edwin
 */
@Slf4j
public class Demo {

	@SneakyThrows
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			HttpResponse response = HttpPackUtil.createGet("test")
					.execute();
			System.out.println(response.body());
		}
	}
}
