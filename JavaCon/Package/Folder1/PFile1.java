//package p1;

public class PFile1{
    void show()
    {
        System.out.println("Inside package p1 show " + getClass().getName());
    }

    public static void main(String[] args) {
        new PFile1().show();
    }
}