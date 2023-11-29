package com.github.xuchen93;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author edwin
 */
@Slf4j
public class Demo {

	@SneakyThrows
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String, Object>(){{
			put("listParams", new HashMap<String, Object>(){{
				put("phone","18012345678");
				put("unikey","18012345678key");
				put("callTime",new Date());
			}});
		}};
		while (true){
			HashMap<String, Object> hashMap = new HashMap<>(map);
			hashMap.put("date", DateUtil.now());
			String jsonStr = JSONUtil.toJsonStr(hashMap);
			log.info(jsonStr);
		}
	}
}
