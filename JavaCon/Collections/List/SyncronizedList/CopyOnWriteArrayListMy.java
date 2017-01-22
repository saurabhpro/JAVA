import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Saurabh on 9/13/2015.
 */

class Thread1 implements Runnable {
	CopyOnWriteArrayList<String> al;

	Thread1(CopyOnWriteArrayList<String> al) {
		this.al = al;
	}

	@Override
	public void run() {
		Iterator i = al.iterator();

		while (i.hasNext()) {
			try {
				String str = (String) i.next();
				System.out.println("Name: " + str);

				Thread.sleep(2000);
			} catch (Exception e) {
				{
					System.out.println("Explain Ready = " + e);
					System.exit(0);
				}
			}
		}
	}
}

class Thread2 implements Runnable {
	CopyOnWriteArrayList<String> al;

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
