/**
 * Created by Saurabh on 8/16/2015.
 */

class Parent extends Exception{

}

class Child extends Parent{

     Child() throws Child {
        throw new Child();
    }
}
public class ExceptionErrorChild  {
    public static void main(String[] args) throws Child{
        try{
            Child c = new Child();
        }
        catch (Exception e){
            System.out.println("Child caught");
        }
    }



}
