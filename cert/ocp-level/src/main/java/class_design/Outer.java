package class_design;

interface Outer2 {        // an outer interface has a static nested class
	static class Inner {
		// implicitly every inner class in interface is static
	}
}

interface Outer4 {        // an outer interface has a static nested interface
	static interface Inner {
	}
}

class Outer1 {            // an outer class has a static nested class
	static class Inner {
	}
}

class Outer3 {            // an outer class has a static nested interface
	static interface Inner {
	}
}
