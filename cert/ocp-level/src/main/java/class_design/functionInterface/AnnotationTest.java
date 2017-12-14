package class_design.functionInterface;

//@FunctionalInterface
//public abstract class AnnotationTest {
//	abstract int foo();
//} not an interface

//@FunctionalInterface
//public interface AnnotationTest {
//	default int foo() {
//		return 0;
//	}
//} no abstract method

@FunctionalInterface
interface Test {
	abstract public void Show();

	abstract public String toString();
}

class K implements Test {

	@Override
	public void Show() {

	}

	//wonder why i dont need to add implementation for toString :P
}