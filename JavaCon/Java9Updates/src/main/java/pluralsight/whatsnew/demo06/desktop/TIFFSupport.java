/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo06.desktop;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TIFFSupport {
	public static void main(String... args) throws IOException {

		// The easy way
		BufferedImage img = ImageIO.read(new File("/Users/saurabhkumar/GitHub/JAVA/JavaCon/Java9OtherUpdates/src/main/resources/sander.tiff"));
		System.out.println("Height: " + img.getHeight());
		System.out.println("Width: " + img.getWidth());

		// The hard way
		ImageInputStream inputStream = ImageIO.createImageInputStream(new File("/Users/saurabhkumar/GitHub/JAVA/JavaCon/Java9OtherUpdates/src/main/resources/sander.tiff"));
		ImageReader tiffReader = ImageIO.getImageReadersByFormatName("tiff").next();
		tiffReader.setInput(inputStream);
		BufferedImage image = tiffReader.read(0);

		System.out.println("Height: " + image.getHeight());
		System.out.println("Width: " + image.getWidth());


	}
}
