package com.github.xuchen93.service;

import com.github.xuchen93.model.CacheModel;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author xuchen.wang
 * @date 2023/6/6
 */
@Service
public class CacheService {

	@Cacheable(value = "getEntity", key = "#id")
	public CacheModel getEntity(Integer id) {
		return new CacheModel(id, "getEntity");
	}
}
