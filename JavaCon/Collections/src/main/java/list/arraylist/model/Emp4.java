package list.arraylist.model;

public class Emp4 {
	public int id;

	public Emp4(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object ob) {
		System.out.println("Inside Equals of main.java.list.arraylist.model.Emp4");
		Emp4 e = (Emp4) ob;
		return this.id == e.id;
	}
}
