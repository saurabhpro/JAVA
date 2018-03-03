package class_design.enums;

public enum Season3 {

	WINTER {
		@Override
		public void printHours() {
			System.out.println("short hours");
		}
	},
	SUMMER {
		@Override
		public void printHours() {
			System.out.println("long hours");
		}
	},
	SPRING,
	FALL;

	/**
	 * this method can be overridden as shown
	 * the enum must start with constant variables i.e. placing this method at top is error
	 */
	public void printHours() {
		System.out.println("default hours");
	}

}