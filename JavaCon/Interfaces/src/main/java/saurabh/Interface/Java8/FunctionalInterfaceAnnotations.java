package saurabh.Interface.Java8;

/*
 * Created by Saurabh on 10/31/2015.
 */

/**
 * functional interface are interfaces with only one abstract method, they were introduced to support Lambda
 * Expressions, which can only be applied to interfaces having only one abstract method
 * <p>
 * we can have additional constants, default and static methods as well inside this interface
 */
@SuppressWarnings("unused")
@FunctionalInterface
public interface FunctionalInterfaceAnnotations {
	void show();
}
