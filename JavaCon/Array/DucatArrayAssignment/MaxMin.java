/**
 * Created by Saurabh on 7/6/2015.
 */
public class MaxMin {

	ArrayD ar = new ArrayD();

	int max(int a[]) {
		int max = a[0];
		for (int i = 1; i < a.length; ++i) {
			if (a[i] > max)
				max = a[i];
		}
		ar.print(a);
		return max;

	}

	int max(int a[][]) {
		int max = a[0][0];
		for (int i = 1; i < a.length; ++i) {
			for (int j = 0; j < a[i].length; ++j)
				if (a[i][j] > max)
					max = a[i][j];
		}
		ar.print(a);
		return max;
	}

	int min(int a[]) {
		int min = a[0];
		for (int i = 1; i < a.length; ++i) {
			if (a[i] < min)
				min = a[i];
		}
		ar.print(a);
		return min;
	}

	int min(int a[][]) {
		int min = a[0][0];
		for (int i = 1; i < a.length; ++i) {
			for (int j = 0; j < a[i].length; ++j)
				if (a[i][j] < min)
					min = a[i][j];
		}
		ar.print(a);
		return min;
	}
}
