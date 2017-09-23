package a_creational.b_builder;

class LunchOrderTele {

	private final String bread;
	private String condiments;
	private String dressing;
	private String meat;

	private LunchOrderTele(String bread) {
		this.bread = bread;
	}

	private LunchOrderTele(String bread, String condiments) {
		this(bread);
		this.condiments = condiments;
	}

	private LunchOrderTele(String bread, String condiments, String dressing) {
		this(bread, condiments);
		this.dressing = dressing;
	}

	public LunchOrderTele(String bread, String condiments, String dressing, String meat) {
		this(bread, condiments, dressing);
		this.meat = meat;
	}

	public String getBread() {
		return bread;
	}

	public String getCondiments() {
		return condiments;
	}

	public String getDressing() {
		return dressing;
	}

	public String getMeat() {
		return meat;
	}
}
