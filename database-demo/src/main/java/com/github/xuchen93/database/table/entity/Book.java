package com.github.xuchen93.database.table.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.xuchen93.database.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author xuchen
 * @since 2020-10-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("bm")
public class Book extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 类型
	 */
	private Integer type;


}
