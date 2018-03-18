/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package methodReference.instanceEx;

/**
 * Created by saurabhkumar on 23/05/17.
 */
interface TriFunction<T, U, V, R> {
	R apply(T t, U u, V v);
}
