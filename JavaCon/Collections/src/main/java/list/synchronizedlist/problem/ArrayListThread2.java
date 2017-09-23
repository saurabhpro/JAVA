package list.synchronizedlist.problem;

import java.util.ArrayList;

class ArrayListThread2 implements Runnable {
	private final ArrayList<String> al;

	ArrayListThread2(ArrayList<String> al) {
		this.al = al;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++)
				al.add("First");
			al.add("Second");
			al.add("Third");
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}
}
