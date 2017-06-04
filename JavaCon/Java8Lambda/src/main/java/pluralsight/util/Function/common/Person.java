package pluralsight.util.Function.common;


/**
 * @author José Paumard
 */
public class Person {

	private String firstName;
	private String lastName;
	private String name;
	private int age;

	public Person() {
	}

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
	}
}