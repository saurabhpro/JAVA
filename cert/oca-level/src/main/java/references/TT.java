package references;

interface TT {
	static int f5() {
		return 0;
	}

	//can't make it final
	default int fr() {
		return 0;
	}
}

interface BH extends TT {
	@Override
	default int fr() {
		return TT.super.fr();
	}
}

class CC implements BH {
	public static void main(String[] args) {
		new CC().go();
	}

	int f5() {
		return 0;
	}

	private void go() {
		System.out.println(this.fr());
		System.out.println(BH.super.fr());
		System.out.println(BH.super.toString());
	}

	public int fr() {
		return 9;
	}
}
