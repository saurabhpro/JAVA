/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions.try_with_resources;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Saurabh on 9/1/2015.
 */

//java.lang
class A implements AutoCloseable {

	@Override
	public void close() {

	}
}

@SuppressWarnings("ALL")
class B implements AutoCloseable {

	/**
	 * Closes this resource, relinquishing any underlying resources.
	 * This method is invoked automatically on objects managed by the
	 * {@code try}-with-resources statement.
	 * <p>
	 * <p>While this interface method is declared to throw {@code
	 * Exception}, implementers are <em>strongly</em> encouraged to
	 * declare concrete implementations of the {@code close} method to
	 * throw more specific exceptions, or to throw no exception at all
	 * if the close operation cannot fail.
	 * <p>
	 * <p> Cases where the close operation may fail require careful
	 * attention by implementers. It is strongly advised to relinquish
	 * the underlying resources and to internally <em>mark</em> the
	 * resource as closed, prior to throwing the exception. The {@code
	 * close} method is unlikely to be invoked more than once and so
	 * this ensures that the resources are released in a timely manner.
	 * Furthermore it reduces problems that could arise when the resource
	 * wraps, or is wrapped, by another resource.
	 * <p>
	 * <p><em>Implementers of this interface are also strongly advised
	 * to not have the {@code close} method throw {@link
	 * InterruptedException}.</em>
	 * <p>
	 * This exception interacts with a thread's interrupted status,
	 * and runtime misbehavior is likely to occur if an {@code
	 * InterruptedException} is {@linkplain Throwable#addSuppressed
	 * suppressed}.
	 * <p>
	 * More generally, if it would cause problems for an
	 * exception to be suppressed, the {@code AutoCloseable.close}
	 * method should not throw it.
	 * <p>
	 * <p>Note that unlike the {@link Closeable#close close}
	 * method of {@link Closeable}, this {@code close} method
	 * is <em>not</em> required to be idempotent.  In other words,
	 * calling this {@code close} method more than once may have some
	 * visible side effect, unlike {@code Closeable.close} which is
	 * required to have no effect if called more than once.
	 * <p>
	 * However, implementers of this interface are strongly encouraged
	 * to make their {@code close} methods idempotent.
	 *
	 * @throws Exception if this resource cannot be closed      //a implementer can choose to have or not have throw
	 */
	@Override
	public void close() {

	}
}

//java.io.*
class C implements Closeable {

	/**
	 * Closes this stream and releases any system resources associated
	 * with it. If the stream is already closed then invoking this
	 * method has no effect.
	 * <p>
	 * <p> As noted in {@link AutoCloseable#close()}, cases where the
	 * close may fail require careful attention. It is strongly advised
	 * to relinquish the underlying resources and to internally
	 * <em>mark</em> the {@code Closeable} as closed, prior to throwing
	 * the {@code IOException}.
	 *
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	public void close() {
		System.out.println("Only IOException or RuntimeException needed");
	}
}

public class TryWithResources {
	public static void main(String[] args) throws Exception {
		//noinspection EmptyTryBlock
		try (A a = new A()) {
		} catch (Exception e) {
			e.printStackTrace();
		} //catch needed as Close() of exceptions.try_with_resources.A throw Exception

		//noinspection EmptyTryBlock
		try (B b = new B()) {
		}   //no catch needed as Close() of exceptions.try_with_resources.B dosent throw Exception

		try (A a = new A(); B b = new B()) {
		    /*
		    Error:(78, 16) java: unreported exception java.lang.Exception; must be caught or declared to be thrown
                 exception thrown from implicit call to close() on resource variable 'a'
             */
			System.out.println("throw of exceptions.try_with_resources.A un-HANDLED so DECLARED main throws Exception, else error");
			System.out.println("Handle(catch) or Declare");
		}
	}
}
