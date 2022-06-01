/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions.try_with_resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("JavaDoc")
class Java9TryWithResourcesImprovement {
    private static final Logger LOG = LoggerFactory.getLogger(Java9TryWithResourcesImprovement.class);

    public static void main(String[] args) throws IOException {
        testARM_Java8();
        testARM_Java9();
    }

    /**
     * Here we have created an utility method which creates a BufferedReader object to read the content of a file.
     * If we observe the above code snippet, even though we have reader1 referring to BufferedReader object,
     * we should create a duplicate one “reader2” to use it in Try-With-Resources.
     * <p>
     * It is one small bug or issue in Java SE 7 or 8 versions.
     * <p>
     * We cannot use any Resource (which is declared outside the Try-With-Resources) within try() block of Try-With-Resources statement.
     * <p>
     *
     * @throws IOException
     * @since jdk 8+
     */
    static void testARM_Java8() throws IOException {
        //noinspection UnnecessaryLocalVariable
        BufferedReader reader1 = new BufferedReader(new FileReader(getFile()));

        try (BufferedReader reader2 = reader1) {
            LOG.info(reader2.readLine());
        }
    }

    /**
     * Below code is invalid in Java SE 7 or 8 versions. It throws compile-time error.
     *
     * @throws IOException
     * @since jdk 9+
     */
    static void testARM_Java9() throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(getFile()));
        try (reader1) {
            LOG.info(reader1.readLine());
        }
    }

    private static String getFile() {
        return Java9TryWithResourcesImprovement.class.getClassLoader().getResource("sample/journaldev.txt").getFile();
    }
}
