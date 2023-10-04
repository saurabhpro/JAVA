/*
 * Copyright (c) 2018 Saurabh Kumar
 */

import java.io.*;

/**
 * Created by Saurabh on 9/14/2015.
 */
public class SimpleReadAndWrite {

    private static void write() throws IOException {
        final var fileWriter = new FileWriter("MyFile.txt");
        final var printWriter = new PrintWriter(fileWriter);

        printWriter.println("Hello There");
        printWriter.println("Folks");
        printWriter.flush();
        printWriter.close();
        fileWriter.close();
    }

    private static void read() {
        try (final var fileReader = new FileReader("MyFile.txt")) {
            final var bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println(data);
            }

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
