package com.github.xuchen93.handler;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Intercepts(
        @Signature(type = ResultSetHandler.class,method = "handleResultSets",args = {Statement.class})
)
@Slf4j
public class MyResultSetInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("==========");
        Object target = invocation.getTarget();
        Statement statement = (Statement) invocation.getArgs()[0];
        if (target instanceof DefaultResultSetHandler){
            DefaultResultSetHandler setHandler = (DefaultResultSetHandler) target;
            List<Object> list = setHandler.handleResultSets(statement);
            if (!list.isEmpty() && list.get(0) instanceof Map){
                return list.stream().map(i->{
                    Map map = (Map) list.get(0);
                    System.out.println("转换前："+JSONUtil.toJsonStr(map));
                    Map result = new LinkedHashMap();
                    map.forEach((k,v)->{
                        result.put(k.toString().toUpperCase(),v);
                    });
                    return result;
                }).collect(Collectors.toList());
            }
        }
        return invocation.proceed();
    }
}
