package class_design;

class SmartWatch2 extends Watch2 {
	private String getType() {
		return "smart watch";
	}

	public String getName() {
		return getType() + ",";
	}
}

public class Watch2 {
	public static void main(String[] args) {
		Watch2 watch = new Watch2();
		Watch2 smartWatch = new SmartWatch2();
		System.out.print(watch.getName(","));
		System.out.print(smartWatch.getName(""));
	}

	private String getType() {
		return "watch";
	}

	public String getName(String suffix) {
		return getType() + suffix;
	}
}