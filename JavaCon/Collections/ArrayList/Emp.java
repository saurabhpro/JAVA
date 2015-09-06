import java.io.Serializable;

/**
 * Created by Saurabh on 9/6/2015.
 */
class Emp {
    int id;
    String name;

    Emp(int x, String st) {
        id = x;
        name = st;
    }


    @Override
    public boolean equals(Object ob) {
        System.out.println("Inside Overridden Equals");
        Emp e1 = (Emp) ob;
       /*
        if(this.id==e1.id) return true;
        else            return false;
        SIMPLIFIED INTO BELOW CODE */

        return this.id == e1.id;
    }
}

class Emp2 implements Serializable {
    int x;

    Emp2(int x) {
        this.x = x;
    }
}
