package com.saurabh.commons; /**
 * Created by Saurabh on 8/7/2015.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class GetAllSubsetByStack {
	static int TARGET_SUM;
	private Stack<Integer> stack = new Stack<>();
	private int sumInStack = 0;

	public static void main(String s[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		TARGET_SUM = Integer.parseInt(br.readLine());
		StringTokenizer strToken = new StringTokenizer(input);
		int count = strToken.countTokens();

		int[] DATA = new int[count];

		for (int x = 0; x < count; x++) {
			DATA[x] = Integer.parseInt((String) strToken.nextElement());
		}

		for (int i = 0; i < DATA.length; i++)
			for (int j = i + 1; j < DATA.length; j++)
				if (DATA[i] == DATA[j])
					DATA[j] = Integer.MAX_VALUE;

		GetAllSubsetByStack get = new GetAllSubsetByStack();
		get.populateSubset(DATA, 0, DATA.length);
	}

	public void populateSubset(int[] data, int fromIndex, int endIndex) {

		if (sumInStack == TARGET_SUM)
			print(stack);
		//  Arrays.sort(new int[]{5,9,6,6});

		for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

			if (sumInStack + data[currentIndex] <= TARGET_SUM) {
				stack.push(data[currentIndex]);
				sumInStack += data[currentIndex];
				populateSubset(data, currentIndex + 1, endIndex);
				sumInStack -= stack.pop();
			}
		}
	}

	private void print(Stack<Integer> stack) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Integer i : stack)
			sb.append(i).append(",");
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		System.out.println(sb.toString());
	}
}
