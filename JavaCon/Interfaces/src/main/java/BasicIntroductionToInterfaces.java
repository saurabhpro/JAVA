/**
 * Created by Saurabh on 8/5/2015.
 */

@FunctionalInterface
@SuppressWarnings("All")
interface Interface {
	void show();        //by default public and abstract
}


// This class contains an instance of class Test1
@SuppressWarnings("All")
public class BasicIntroductionToInterfaces implements Interface {

	private Test1 t1 = new Test1(10);

	private BasicIntroductionToInterfaces(int i) {
		t1 = new Test1(i);
	}

	public static void main(String[] args) {
		BasicIntroductionToInterfaces t2 = new BasicIntroductionToInterfaces(5);

		Interface m = new BasicIntroductionToInterfaces(5);    // Interface is interface and here a base class, so this is allowed

		System.out.println('a' - 'A');
	}

	@Override
	public void show()  //if public not given it sees an error : attempting to give weaker access than public in interface
	{
		System.out.printf("Hey");
	}
}

// filename: BasicIntroductionToInterfaces.java
class Test1 {
	Test1(int x) {
		System.out.println("Constructor called " + x);
	}
}