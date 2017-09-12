import java.io.*;

public class CodeVita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader y = new BufferedReader(x);
        
        int n = Integer.parseInt(y.readLine().toString());
        
        double num=0;
        for(int i =0;i<n;i++)
        {
            num = Integer.parseInt(y.readLine());
            int bottles =0;
            if(num>=10)
            {
                bottles += (int) Math.floor(num/10);
                num = num%10;
            }
            
            if(num>=7)
            {
                bottles += (int) Math.floor(num/7);
                num = num%7;
            }
            
            if(num>=5)
            {
                bottles += (int) Math.floor(num/5);
                num = num%5;
                
            }
            
            if(num>=1)
            {
                bottles += (int) Math.floor(num/1);
                num = num%1;
                
            }
            if(num >0)
				bottles =bottles+1;
			
            System.out.println(bottles);
            
        }
        
        
    }
    
}