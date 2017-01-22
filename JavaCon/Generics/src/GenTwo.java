public class GenTwo {
	public static void main(String[] args) {
		Gen2<Integer, String> iOb = new Gen2<Integer, String>(88, "Hello");      //or use diamond operator <> with constructor jdk16++
		Gen2<String, Double> strOb = new Gen2<>("Hello", 85.0);

		System.out.println(iOb.getVar() + " " + iOb.getVar2());
		iOb.showType();

		System.out.println(strOb.getVar() + " " + strOb.getVar2());
		strOb.showType();

		//System.out.println(strOb == iOb); Coz type alag hai

		Emp e1 = new Emp();
		Gen<Emp> eOb = new Gen<>(e1);
		eOb.showType();

		System.out.println(e1.x);
	}
}


class Gen2<T, V> {
	T var;
	V var2;

	Gen2(T val, V val2) {
		this.var = val;
		var2 = val2;
	}

	T getVar() {
		return var;
	}

	V getVar2() {
		return var2;
	}

	//RTTI Function
	void showType() {
		Class c = var.getClass();
		System.out.println("Type of T is : " + c.getName() + " Type of V is : " + var2.getClass().getName());
	}
}

class Emp<T> {
	int x;

	Emp() {
		x = 15;
	}
}