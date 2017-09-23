/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
