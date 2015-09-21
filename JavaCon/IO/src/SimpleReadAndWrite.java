import java.io.*;

/**
 * Created by Saurabh on 9/14/2015.
 */
public class SimpleReadAndWrite {
    static void write() throws IOException {
        FileWriter fileWriter = new FileWriter("MyFile.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("Hello There");
        printWriter.println("Folks");
        fileWriter.close();
    }

    static void read() throws FileNotFoundException {
        try (FileReader fileReader = new FileReader("MyFile.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null)
                System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            write();
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
