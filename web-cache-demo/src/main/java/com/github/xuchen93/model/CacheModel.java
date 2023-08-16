package com.github.xuchen93.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * @author edwin
 */
@Data
public class CacheModel implements Serializable {
	private Integer type;
	private String name;
	private LocalTime time = LocalTime.now();

	public CacheModel(Integer type, String name) {
		this.type = type;
		this.name = name;
	}
}
