package data_type;

public class LoopsAndChecks {
	public static void main(String[] args) {
		if (true) {
		} else if (4 < 9) {
			System.out.println("4 ^ 9 = " + (4 ^ 9));
		}

		long thatNumber = 5 >= 5 ? 1 + 2 : 1 * 1;
		if (++thatNumber < 4)
			thatNumber += 1;
		System.out.println(thatNumber);

		switchTypeSupported();

		labeledContinue();

		// infinite();


		for (int i = 8; i < 10; i++, System.out.println(i + " ")) {

			// forced exit
			// break;
			// System.exit(0);
			// return f3;
		}
	}

	private static void switchTypeSupported() {
		//		long & boolean are not supported
//		long x = 10;
//		switch (x){
//			case 10: break;
//		}

		int r = 8;
		String s = "t";
		switch (r) {
			//case r: constant required
			//case s: type mismatch
		}

		final String s2 = "6";
		final String s3;
		s3 = "5";
		switch (s) {
			//case s: constant required
			case s2:
				break;
			//case s3: compile-time constant required
		}


		int i1 = 5;
		switch (i1) {
			// blank is also allowed
		}
		byte b1 = 9;        // allowed upto -128 to 127
		switch (b1) {
			case 0b101:
				System.out.println(0b101);
				break;
			case 9:
				break;
			case 0x53:
				//case 128: break; wont compile
			case 2 * 2:
				break;
		}
	}

	private static void labeledContinue() {
		boolean b;
		if (b = true) {
			int c = 7;
			int res = 4;

			res += ++c;
			System.out.println(res);

			int count = 0;
			ROW_LOOP:
			for (int row = 1; row <= 3; row++)
				for (int col = 1; col <= 2; col++) {
					if (row * col % 2 == 0) continue ROW_LOOP;
					count++;
				}
			System.out.println(count);
		}
	}

	private static void infinite() {
		for (int i = 0; i < 10; ) {
			i = i++;
			System.out.println("Hello World");
		}
	}

	public void findAnswer(boolean check) {
		int answer;
		int onlyOneBranch;
		if (check) {
			onlyOneBranch = 1;
			answer = 1;
		} else {
			answer = 2;
		}
		System.out.println(answer);
		//System.out.println(onlyOneBranch); // DOES NOT COMPILE }

	}
}


class FeedingSchedule {
	public static void main(String[] args) {
		int x = 5, j = 0;
		OUTER:
		for (int i = 0; i < 3; )
			INNER:
					do {
						x++;
						i++;
						if (x > 10) break INNER;
						x += 4;
						j++;
					} while (j <= 2);

		System.out.println(x);
	}
}