import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Saurabh on 8/12/2015.
 */
public class SumTillNum {
    public static void main(String[] args) {
        SumTillNum s1 = new SumTillNum();
        s1.ValuesTillSum();
    }

    void ValuesTillSum()
    {
        Scanner sc = new Scanner(System.in);
        int ar[] = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

//46,1,2,1,2,48,50,49

        int value = sc.nextInt();
        int sum=0;
        int remaining=value;

        for(int i =0, k = 2, j; i<ar.length; i++, k++)
        {
            int m = k;
            sum=0; remaining = value; j =i;
          //  System.out.println(sum+" "+remaining);
            while(m>0 )
            {
                if(ar[j]<= remaining)
                {
                    sum+=ar[j];
                    remaining = value-sum;
                    System.out.print(ar[j]+" ");
                }
                j++;
                System.out.println("\n\n\n Sum and reamain while "+sum+" "+remaining);
                if(remaining>0 ){
                    m--;
                }
                else break;

            }
            if(sum==value) System.out.println("m="+k);


        }
    }
}
