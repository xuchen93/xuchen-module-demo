package com.github.xuchen93.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author xuchen.wang
 * @date 2023/9/15
 */
@Mapper
public interface MyTestMapper {

    Map<String,Object> getById(Long id);

    List<Map<String,Object>> getList();
}
