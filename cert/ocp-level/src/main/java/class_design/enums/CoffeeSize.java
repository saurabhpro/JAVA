package class_design.enums;

public enum CoffeeSize {
	BIG(8),
	HUGE(10),
	OVERWHELMING(20) {
		// when we intend to override the general method written in the enum
		@Override
		public int getValue() {
			return this.value + 10;
		}
	};  // this semi colon is required when more code follows

	//private final int value;    // Error:(10, 36) java: value has private access in random.CoffeeSize
	final int value;

	// implicitly private
	CoffeeSize(int size) {
		this.value = size;
	}

	public int getValue() {
		return this.value;
	}
}