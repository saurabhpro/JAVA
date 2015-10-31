/**
 * Created by Saurabh on 9/2/2015.
 * Abstract classes are only used now when we want mutable instance variables,
 * other than that there is virtually no difference between abstract classes and interfaces from java 8
 */

abstract class Animal {
    abstract void eat();

    abstract void speak();

    void sleep() {
        System.out.println("sleep");
    }

}

public class AbstractClassInstantiation {

    public static void main(String[] args) {
        new Animal() {
            @Override
            void eat() {

            }

            @Override
            void speak() {

            }
        };  //Anonymous class is created which is basically a subclass of abstract animal, which is legal
        //we are not creating instance of abstract class, any Anonymous class must be concrete
    }
}
