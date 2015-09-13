import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Saurabh on 9/13/2015.
 * java.util.ConcurrentModificationException
 * When Thread1 comes back, it will throw  this Exception
 */

class ArrayListThread1 implements Runnable {
    ArrayList<String> al;

    ArrayListThread1(ArrayList<String> al) {
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

class ArrayListThread2 implements Runnable {
    ArrayList<String> al;

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

public class ArrayListProblem {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        try {
            ArrayListThread1 arrayListThread1 = new ArrayListThread1(arrayList);
            Thread t1 = new Thread(arrayListThread1);

            ArrayListThread2 arrayListThread2 = new ArrayListThread2(arrayList);
            Thread t2 = new Thread(arrayListThread2);

            t1.setPriority(10);
            t2.setPriority(1);

            t1.start();
            t2.start();
        } catch (Exception e) {
            System.out.println("Exception : " + e);

        }
    }
}
