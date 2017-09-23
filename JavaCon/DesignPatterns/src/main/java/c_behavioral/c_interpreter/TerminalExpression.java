package c_behavioral.c_interpreter;

import java.util.Arrays;

public class TerminalExpression implements Expression {

	private final String data;

	public TerminalExpression(String data) {
		this.data = data;
	}

	@Override
	public boolean interpret(String str) {
//		StringTokenizer st = new StringTokenizer(str);
//		while (st.hasMoreTokens()) {
//			String test = st.nextToken();
//			if (test.equals(data)) {
//				return true;
//			}
//		}
//
//      String[] st = str.split("\t\n\r\f");
//		for (String s : st) {
//			if (s.equals(data)) {
//				return true;
//			}
//		}

		return Arrays.stream(str.split(" ")).anyMatch(s -> s.equals(data));
	}
}