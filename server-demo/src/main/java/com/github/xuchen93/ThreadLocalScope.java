package com.github.xuchen93;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @author edwin
 */
public class ThreadLocalScope implements Scope {
	private final ThreadLocal<Map<String, Object>> THREAD_LOCAL_SCOPE =
			ThreadLocal.withInitial(HashMap::new);

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
		THREAD_LOCAL_SCOPE.get().remove(name);
		return null;
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
