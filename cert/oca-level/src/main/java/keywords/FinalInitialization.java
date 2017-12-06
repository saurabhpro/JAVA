package keywords;

public class FinalInitialization {
	//finalse must be initialized till construction
	//private final Object contents;
	private final Object contents = null;

	public static void main(String[] treats) {
		FinalInitialization gift = new FinalInitialization();
		gift.setContents(gift);
		gift.showPresent();
	}

	protected Object getContents() {
		return contents;
	}

	protected void setContents(Object contents) {
		//this.contents = contents; final - so not allowed
	}

	public void showPresent() {
		System.out.print("Your gift: " + contents);
	}
}
