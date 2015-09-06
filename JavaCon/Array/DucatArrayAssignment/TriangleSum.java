/**
 * Created by Saurabh on 7/6/2015.
 */
public class TriangleSum {
    ArrayD ar = new ArrayD();
    int lowerTriangleSum(int a[][])
    {
        /*
        1
        1 2
        1 2 3
        sum =  10
        */

        int i = 0, j=0;
        int sum = 0;

        while(i<a.length){
            while(j<=i)
                sum+=a[i][j++];
            i++;
            j=0;
        }
        ar.print(a);
        return sum;
    }

    int upperTriangleSum(int a[][])
    {
        /*
        1 2 3
          1 2
            1
        sum =  10
        */

        int i = 0, j=a.length-1;
        int sum = 0;

        while(i<a.length){
            while(j>=i)
                sum+=a[i][j--];
            i++;
            j=a.length-1;
        }
        ar.print(a);
        return sum;
    }
}
