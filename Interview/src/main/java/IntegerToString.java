/**
 * Created by saurabhkumar on 19/07/17.
 *
 * @BeforeClass: The annotated method will be run before the first test method in the current class is invoked.
 * @BeforeTest: The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
 */
class IntegerToString {
	void printIn(int n, int radix) {
		System.out.println(Integer.toString(n, radix));
	}
}
