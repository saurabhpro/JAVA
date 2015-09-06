/**
 * Created by Saurabh on 7/6/2015.
 */
public class SnakePrinting {
    ArrayD ar = new ArrayD();
    void printDiagonally(int a[][])
    {
        ar.print(a);
        int i, j;
        i=j=0;
        int max, imin, jmin;
        max= a.length-1;
        imin=jmin=0;

        while(imin<=max && jmin<=max)
        {
            i = imin;
            j = jmin;
            while(i>=jmin)
              //  System.out.println("imin ="+ imin+" jmin= "+ jmin+ " i = "+ (i-1)+" j = "+ (j+1));
                System.out.print(a[i--][j++]+" ");

            System.out.println();
            if(imin==max)
                jmin++;
            else
                imin++;
        }
    }

    void printSnakes(int a[][])
    {
        ar.print(a);

        int imin, jmin;
        imin = jmin = 0;
        int iteration = 0;
        int max = a.length-1;
        int i , j;
        i=j=0;

        while(iteration <= a.length+2)
        {
            if(iteration %2 ==0)
            {
                if (iteration >max)
                {
                    i=max;
                    jmin = imin = iteration-max;
                    j = jmin;
                }
                else
                {
                    i = iteration - jmin;
                    j = jmin;
                }
                while((i+j) == iteration && i>=imin && j>=jmin){
                   // System.out.println("UTD imin ="+ imin+" jmin= "+ jmin+ " i = "+ (i)+" j = "+ (j));
                    System.out.print(a[i--][j++]+" ");
                }
                System.out.println();
            }
            else
            {
                if(iteration >max)
                {
                    j = max;
                    imin = jmin= iteration-max;
                    i = imin;
                }
                else
                {
                    j = iteration - imin;
                    i = imin;
                }
                while((i+j) == iteration && i>=imin && j>=jmin) {
                    //System.out.println("DTU imin =" + imin + " jmin= " + jmin + " i = " + i + " j = " + j);
                    System.out.print(a[i++][j--] + " ");
                }
                System.out.println();
            }

            iteration++;
        }
    }
}
