package com.hccs.samples.sample.gps.boot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Context {
	private static Map<String, AnnotationConfigApplicationContext> contextMap;
	private static AnnotationConfigApplicationContext context;

	public static void initialize() {
		contextMap = new HashMap<>();
	}

	public static <T> T getBean(Class<T> clazz) {
		if (Objects.isNull(context))
			throw new RuntimeException("No context lookup. Try invoking the lookup method first.");

		return context.getBean(clazz);
	}

	public static void lookup(String key, Class configClass) {
		if (contextMap.isEmpty() || !contextMap.keySet().contains(key)) {
			context = new AnnotationConfigApplicationContext(configClass);
			contextMap.put(key, context);
		} else {
			context = contextMap.get(key);
		}
	}
}
