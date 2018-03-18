/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo06.desktop;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;
import java.io.File;
import java.io.IOException;

public class MultiResolutionImages {

	public static void main(String[] args) throws IOException {
		MultiResolutionImage mr = loadImages();

		Image lowres = mr.getResolutionVariant(50, 50);
		Image highres = mr.getResolutionVariant(200, 200);

		System.out.printf("Width for 50: %d%n", lowres.getWidth(null));
		System.out.printf("Width for 200: %d%n", highres.getWidth(null));
	}

	private static MultiResolutionImage loadImages() throws IOException {
		Image[] sanders = new Image[]{
				ImageIO.read(new File("/Users/saurabhkumar/GitHub/JAVA/JavaCon/Java9OtherUpdates/src/main/resources/sander_lowres.png")),
				ImageIO.read(new File("/Users/saurabhkumar/GitHub/JAVA/JavaCon/Java9OtherUpdates/src/main/resources/sander.png"))
		};
		return new BaseMultiResolutionImage(sanders);
	}

}
