/**
 * Created by Saurabh on 9/2/2015.
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
        };  //Anonymous class is created which is basically a subclass of abstract animal, which is leagal
        //we are not creating instance of abstract class, any Anonymous class must be concrete
    }
}
