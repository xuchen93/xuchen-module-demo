package com.github.xuchen93;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @author edwin
 */
public class ThreadLocalScope implements Scope {
	private static final ThreadLocal THREAD_LOCAL_SCOPE;

	static {
		THREAD_LOCAL_SCOPE = new ThreadLocal<>();

	}

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		System.out.println("----get对象----");
		Object value = THREAD_LOCAL_SCOPE.get();
		if (value != null) {
			return value;
		}
		Object object = objectFactory.getObject();
		THREAD_LOCAL_SCOPE.get();
		return object;
	}

	@Override
	public Object remove(String name) {
		System.out.println("----销毁对象----");
		THREAD_LOCAL_SCOPE.remove();
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
