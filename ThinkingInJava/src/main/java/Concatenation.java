/**
 * Created by Saurabh on 7/14/2015.
 */
public class Concatenation
{
    public void stringType()
    {
        String mango = "mango";
        String s1 = "mango";
        String s = "abc"+mango + "def"+47;
        String s2 = new String("hello");
        String s3 = new String("hello");


        System.out.println(s1==mango);
        System.out.println(s2==s3);
    }
    public String implicit (String[] fields)
    {
        String result = "";
        for(int i = 0; i<fields.length;i++)
        {
            result+=fields[i];
        }
        return result;
    }

    public String explicit(String[] fields)
    {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i<fields.length; i++)
            //result+=fields[i];    wont work as stringbuilder dont have + as concatenation
            result.append(fields[i]);

        return result.toString();
    }
    public static void main(String[] args) {
        Concatenation obj = new Concatenation();
        String[] fields = {"1 ", "2 ", "2 "};
        obj.stringType();
        System.out.println(obj.implicit(fields));
        System.out.println(obj.explicit(fields));
    }
}
