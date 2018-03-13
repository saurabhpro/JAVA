package streams.functional;

import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierIn {
	public static void main(String[] args) {
		Supplier<ArrayList<String>> s1 = ArrayList<String>::new;

		ArrayList<String> a1 = s1.get();

		System.out.println(a1);
	}
}
