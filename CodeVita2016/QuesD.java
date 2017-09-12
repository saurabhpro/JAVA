import java.io.*;

public class QuesD{

   
    public static void main(String[] args)throws IOException {
        InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader y = new BufferedReader(x);
        
        int n = Integer.parseInt(y.readLine().toString());
        
        int arr[] = new int[n];
        for(int i =0;i<n;i++)
        {
            arr[i] = Integer.parseInt(y.readLine());
        }
        int t = Integer.parseInt(y.readLine());
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(arr[i]+arr[j]+arr[k]==t && i!=j && i!=k && j!=k)
                    {
                        System.out.println("True");
                        return;
                    }
                }
            }
        }
        System.out.println("False");
    
    }
    
}