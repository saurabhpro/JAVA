/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package generics.reflection.a_class_literals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
class Injector {
	private final Map<Class<?>, Object> objectGraph = new HashMap<>();

	<T> T newInstance(Class<T> type) {
		return (T) objectGraph.computeIfAbsent(type, this::instantiate);
	}

	Injector with(Object value) {
		objectGraph.put(value.getClass(), value);
		return this;
	}

	private Object instantiate(Class<?> type) {
		try {
			Constructor<?>[] constructors = type.getConstructors();
			if (constructors.length != 1) {
				throw new IllegalArgumentException(type + " must only have 1 constructor");
			}

			Constructor<?> constructor = constructors[0];
			Object[] args = Stream.of(constructor.getParameterTypes())
					.map(param -> (Object) newInstance(param))
					.toArray();

			Objects.requireNonNull(args);

			return constructor.newInstance(args);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
