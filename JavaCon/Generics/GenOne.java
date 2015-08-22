/* Simple generics with RunTimeTypeInformation*/

class Gen<T> {
    T var;

    Gen(T val) {
        this.var = val;
    }

    T getVar() {
        return var;
    }

    //RTTI Function
    void showType() {
        Class c = var.getClass();
        System.out.println("Type of T is :" + c.getName());
        //System.out.println("Type of T is :"+ var.getClass().getName());     way-2
    }
}

public class GenOne {
    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<Integer>(88);      //or use diamond operator <> with constructor
        Gen<String> strOb = new Gen<>("Hello");

        System.out.println(iOb.getVar());
        iOb.showType();

        System.out.println(strOb.getVar());
        strOb.showType();

    }
}