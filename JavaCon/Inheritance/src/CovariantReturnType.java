/**
 * Created by Saurabh on 8/14/2015.
 */

/*
Java has covariant return types, so if you want to provide a more strongly typed
implementation than the interface specifies, that's okay. For instance, this is fine:

Covariant return types circa jdk 1.5
changes its return type to subclass type [return types has to be non-primitive] eg. Foo3, Foo4
 */
interface Foo {
    Object getBar();        //Object
}

interface Foo2{
    String getBar();
}

interface Foo3{
    Number getBar();
}

interface Foo4{
    Integer getBar();
}

//if both interfaces implemented simultaneously
// case 1 : one of two is Object type, strict wala chlega eg. class T1
// case 2: both strict - Error ayega! eg class T2
class T1 implements Foo, Foo2 {
    @Override
    public String getBar() {
        return "Hi";
    }
}

class T2 implements Foo3, Foo4{
    @Override
    public Integer getBar() {
        return null;
    }

}

class Test implements Foo, Foo2{
    // There can only be one implementation of this method.

    /*
    What you can do is compose a class out of two classes that each implement a different interface.
    Then that one class will have the behavior of both interfaces.

class CompositeClass {
    ISomething class1;
    ISomething2 class2;
    void doSomething1(){class1.doSomething();}
    void doSomething2(){class2.doSomething();}
}
     */

    //Any Class return type works with Object
    public String getBar()    {        return "hi";    }
    // public Integer getBar()    {        return 5;    }

    //public T1 getBar() {        return new T1();    }

}

public class CovariantReturnType {
    static Test t = new Test();

    public static void main(String[] args) {
        System.out.println(t.getBar());
    }

}
