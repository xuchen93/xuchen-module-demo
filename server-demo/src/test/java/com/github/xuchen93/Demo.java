package com.github.xuchen93;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.github.xuchen93.web.common.HttpPackUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author edwin
 */
@Slf4j
public class Demo {

	@SneakyThrows
	public static void main(String[] args) {
//		HttpPackUtil.hello();
//		HttpResponse response = HttpPackUtil.createGet("test").execute();
//		System.out.println(response.body());
//		System.out.println(HttpPackUtil.createPost("/post")
//				.body(JSONUtil.toJsonStr(new HashMap<String, Object>(){{
//					put("name","name1");
//				}}))
//				.execute());
//		List<Map<String,Object>> list = new ArrayList<>();
//		list.add(new HashMap<String, Object>(){{
//			put("name","name1");
//		}});
//		list.add(new HashMap<String, Object>(){{
//			put("name","name2");
//		}});
		Map<String,Object> map = new HashMap<>();
		map.put("name","name3");

//		System.out.println(HttpPackUtil.createPost("/post")
//				.body(JSONUtil.toJsonStr(list.get(0)))
//				.execute());
//		System.out.println(HttpPackUtil.createPost("/post/list1")
//				.body(JSONUtil.toJsonStr(list))
//				.execute());
//		System.out.println(HttpPackUtil.createPost("/post/list2")
//				.body(JSONUtil.toJsonStr(list))
//				.execute());
		System.out.println(HttpPackUtil.createPost("/post/list3")
				.body(JSONUtil.toJsonStr(map))
				.execute());
	}
}
