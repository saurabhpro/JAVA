/**
 * Created by Saurabh on 7/6/2015.
 */
public class ArrayD {
    void print(int a[])
    {
        for (int i = 0; i <a.length; ++i)
            System.out.printf("%4d ",a[i]);

        System.out.println();
    }

    void print(int a[][])
    {
        for (int i = 0; i <a.length; ++i)
        {
            for(int j = 0; j<a[i].length; ++j) {
                System.out.printf("%4d ",a[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
      //  int choice = 0;
     //   System.out.println("Menu\1.Min Max\n2. Union\n3. Intersection\n4. 2D Matrix Sum\n5. 2D Matrix");
      /*  MaxMin obj = new MaxMin();

        System.out.println( obj.max(new int[]{1, 7, 9, 8}));
        System.out.println(obj.max(new int[][]{{1, 7, 9, 8}, {5,6,7,2,9,12}}));

        TriangleSum tsum = new TriangleSum();
        System.out.println(tsum.lowerTriangleSum(new int[][]{{1, 2, 3}, {4,5, 6}, {7,8,9}}));
        System.out.println(tsum.upperTriangleSum(new int[][]{{1, 2, 3}, {4,5, 6}, {7,8,9}}));

        SnakePrinting sprin = new SnakePrinting();
        sprin.printDiagonally(new int[][]{{1, 2, 3}, {4,5, 6}, {7,8,9}});
        sprin.printSnakes(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14,15,16}});

        */
    }
}
