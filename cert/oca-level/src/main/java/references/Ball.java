package references;

// abstract class with public constructor
interface Equipment {
}

abstract class Ball {
	protected final int size;

	public Ball(int size) {
		this.size = size;
	}
}

class SoccerBall extends Ball implements Equipment {
	public SoccerBall() {
		super(5);
	}

	public static void main(String[] passes) throws Exception {
		//look at this multiple casting - or is it!

		// since it extends both Ball and Equipment - both can be used to upcast it - but it doesn't chnage the actual object in memory
		// reference only selects what to access - actual object remains same

		Equipment equipment = (Equipment) (Ball) new SoccerBall().get();
		System.out.print(((SoccerBall) equipment).size);
	}

	public Ball get() {
		return this;
	}
}