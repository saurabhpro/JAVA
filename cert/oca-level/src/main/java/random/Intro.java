package random;

class Egret {
	private String color;

	public Egret() {
		this("white");
	}

	public Egret(String color) {
		color = color;
	}

	public static void main(String[] args) {
		Egret e = new Egret();
		System.out.println("Color:" + e.color);
	}
}

class ThreadDemo {
	public static void main(String[] args) throws Exception {
		MyThread t = new MyThread();
		Thread t1 = new Thread(t);
		t1.start();
		System.out.println("main Thread");
	}
}

class MyThread extends Thread {
	public void run() {
		System.out.println("child Thread");
	}
}
