/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package udemy.latency;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class to show how multiple threads can help using a photo to color in purple
 */
public class ImageRecolorUsingThreads {

    private static final Logger logger = Logger.getLogger(ImageRecolorUsingThreads.class.getSimpleName());

    public static final String SOURCE_FILE = "./Concurrency/src/main/resources/many-flowers.jpg";
    public static final String DESTINATION_FILE = "./Concurrency/src/main/resources/many-flowers2.jpg";

    public static void main(String[] args) throws IOException {

        // checking the file path
        Path yo = Paths.get(SOURCE_FILE);
        logger.fine(yo.toAbsolutePath() + "");

        if (Files.exists(yo, LinkOption.NOFOLLOW_LINKS)) {

            BufferedImage originalImage = ImageIO.read(new File(SOURCE_FILE));
            BufferedImage resultImage = new BufferedImage(
                    originalImage.getWidth(),
                    originalImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB
            );

            long startTime = System.currentTimeMillis();

            //recolorSingleThreaded(originalImage, resultImage);

            // should be the number of cores ?
            int numberOfThreads = 6;
            recolorMultiThreaded(originalImage, resultImage, numberOfThreads);

            long duration = System.currentTimeMillis() - startTime;

            File outputFile = new File(DESTINATION_FILE);
            ImageIO.write(resultImage, "jpg", outputFile);

            System.out.println("Total Time taken with " + numberOfThreads + " threads: " + duration);
        }
    }

    public static void recolorMultiThreaded(BufferedImage originalImage, BufferedImage resultImage, int numberOfThreads) {
        List<Thread> threads = new ArrayList<>();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight() / numberOfThreads;   // split the image vertically

        for (int i = 0; i < numberOfThreads; i++) {
            final int threadMultiplier = i;

            Thread thread = new Thread(() -> {
                int xOrigin = 0;
                int yOrigin = height * threadMultiplier;

                recolorImage(originalImage, resultImage, xOrigin, yOrigin, width, height);
            });

            threads.add(thread);
        }

        // start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ignored) {
            }
        }
    }

    public static void recolorSingleThreaded(BufferedImage originalImage, BufferedImage resultImage) {
        recolorImage(originalImage, resultImage, 0, 0, originalImage.getWidth(), originalImage.getHeight());
    }

    private static void recolorImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner, int topCorner,
                                     int width, int height) {

        for (int x = leftCorner; x < leftCorner + width && x < originalImage.getWidth(); x++) {

            for (int y = topCorner; y < topCorner + height && y < originalImage.getHeight(); y++) {
                recolorPixel(originalImage, resultImage, x, y);
            }
        }
    }

    private static void recolorPixel(BufferedImage originalImage, BufferedImage resultImage, int x, int y) {
        int rgb = originalImage.getRGB(x, y);

        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed;
        int newGreen;
        int newBlue;

        if (isShadeOfGray(red, green, blue)) {
            newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);   // make it purple
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }

        int newRGB = createRGBFromColors(newRed, newGreen, newBlue);
        setRGB(resultImage, x, y, newRGB);
    }

    private static void setRGB(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    private static boolean isShadeOfGray(int red, int green, int blue) {
        return Math.abs(red - green) < 30
                && Math.abs(red - blue) < 30
                && Math.abs(green - blue) < 30;
    }

    private static int createRGBFromColors(int red, int green, int blue) {
        int rgb = 0;

        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;

        rgb |= 0xFF000000;  // alpha

        return rgb;
    }

    private static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    private static int getGreen(int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    private static int getBlue(int rgb) {
        return rgb & 0x000000FF;
    }
}
