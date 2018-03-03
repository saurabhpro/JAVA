package class_design;

public class SingletonOk {
	private static volatile SingletonOk instance;

	public static SingletonOk getInstance() {
		// we  first test if synchronization is needed before actually acquiring any locks.
		if (instance == null) {
			synchronized (SingletonOk.class) {
				if (instance == null) {
					instance = new SingletonOk();
				}
			}
		}
		return instance;
	}
}
