package com.github.xuchen93;

import cn.hutool.core.thread.ThreadUtil;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author edwin
 */
public class ThreadLocalScope implements Scope {
	private static final ThreadLocal<Map<String,Object>> THREAD_LOCAL_SCOPE;
	static {
		THREAD_LOCAL_SCOPE = new ThreadLocal<>();
		THREAD_LOCAL_SCOPE.set(new HashMap<>());
	}

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		System.out.println("----get对象----");
		Object value = THREAD_LOCAL_SCOPE.get().get(name);
		if (value != null) {
			return value;
		}
		Object object = objectFactory.getObject();
		THREAD_LOCAL_SCOPE.get().put(name,object);
		return object;
	}

	@Override
	public Object remove(String name) {
		System.out.println("----销毁对象----");
		return THREAD_LOCAL_SCOPE.get().remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {

	}

	@Override
	public Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public String getConversationId() {
		return null;
	}
}
