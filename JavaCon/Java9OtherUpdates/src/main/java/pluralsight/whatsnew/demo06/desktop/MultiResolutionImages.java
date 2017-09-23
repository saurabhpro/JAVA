/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
