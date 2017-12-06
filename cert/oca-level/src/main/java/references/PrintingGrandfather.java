package references;

public class PrintingGrandfather {
	static class A {
		int x = 10;
	}

	static class B extends A {
		int x = 20;
	}

	static class C extends B {
		int x = 30;
	}

	static class D extends C {
		int x = 40;

		void show() {
			System.out.println(x);
			System.out.println(super.x);
			System.out.println(((B) this).x);
			System.out.println(((A) this).x);
		}

	}

	static class T1 {

		public static void main(String[] args) {
			D t = new D();
			System.out.println(t.x);
			System.out.println(((C) t).x);
			System.out.println(((B) t).x);
			System.out.println(((A) t).x);

			//
			t.show();
		}
	}

}
