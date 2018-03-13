package class_design;

class NewSmartWatch extends SmartWatch {
	@Override
	public String show() {
		return "-NSW-\n";
	}
}


class SmartWatch extends Watch {
	private String getType() {
		return "smart watch";
	}

	@Override
	public String getName(String suffix) {
		return getType() + suffix + show(); // calls its own
	}

	@Override
	public String show() {
		return "-SW-\n";
	}
}

public class Watch {
	public static void main(String[] args) {
		Watch watch = new Watch();
		SmartWatch smartWatch = new SmartWatch();
		System.out.print(watch.getName(","));
		System.out.print(smartWatch.getName(""));

		Watch watch1 = new SmartWatch();
		System.out.print(watch1.getName(""));
		System.out.print(watch1.show());

		Watch watch2 = new NewSmartWatch();
		System.out.print(watch2.getName("$$"));
		System.out.print(watch2.show());
	}

	private String getType() {
		return "watch";
	}

	public String getName(String suffix) {
		return getType() + suffix + show();
	}

	public String show() {
		return "-W-\n";
	}
}