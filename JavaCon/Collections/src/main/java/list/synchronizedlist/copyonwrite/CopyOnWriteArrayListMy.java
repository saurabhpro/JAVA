package list.synchronizedlist.copyonwrite;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListMy {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");

		try {
			Thread1 thread1 = new Thread1(arrayList);
			Thread t1 = new Thread(thread1);

			Thread2 thread2 = new Thread2(arrayList);
			Thread t2 = new Thread(thread2);

			t1.setPriority(10);
			t2.setPriority(1);

			t1.start();
			t2.start();
		} catch (Exception e) {
			System.out.println("Exception : " + e);

		}
	}
}
