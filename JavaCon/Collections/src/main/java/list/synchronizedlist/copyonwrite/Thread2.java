package list.synchronizedlist.copyonwrite;

import java.util.concurrent.CopyOnWriteArrayList;

class Thread2 implements Runnable {
	private final CopyOnWriteArrayList<String> al;

	Thread2(CopyOnWriteArrayList<String> al) {
		this.al = al;
	}

	@Override
	public void run() {
		try {
			al.add("First");
			al.add("Second");
			al.add("Third");
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}
}
