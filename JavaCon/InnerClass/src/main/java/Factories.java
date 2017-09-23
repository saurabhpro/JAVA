//: innerclasses/Factories.java

interface Service {
	void method1();

	void method2();
}

@FunctionalInterface
interface ServiceFactory {
	Service getService();
}

@SuppressWarnings("ALL")
class Implementation1 implements Service {
	public static final ServiceFactory factory =
			new ServiceFactory() {
				public Service getService() {
					return new Implementation1();
				}
			};

	private Implementation1() {
	}

	public void method1() {
		System.out.println("Implementation1 method1");
	}

	public void method2() {
		System.out.println("Implementation1 method2");
	}
}

@SuppressWarnings("ALL")
class Implementation2 implements Service {
	public static final ServiceFactory factory =
			new ServiceFactory() {
				public Service getService() {
					return new Implementation2();
				}
			};

	private Implementation2() {
	}

	public void method1() {
		System.out.println("Implementation2 method1");
	}

	public void method2() {
		System.out.println("Implementation2 method2");
	}
}

public class Factories {
	private static void serviceConsumer(ServiceFactory fact) {
		Service s = fact.getService();
		s.method1();
		s.method2();
	}

	public static void main(String[] args) {
		serviceConsumer(Implementation1.factory);
		// Implementations are completely interchangeable:
		serviceConsumer(Implementation2.factory);
	}
} /* Output:
Implementation1 method1
Implementation1 method2
Implementation2 method1
Implementation2 method2
*///:~
