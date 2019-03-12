/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package udemy.latency;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static udemy.latency.ImageRecolorUsingThreads.SOURCE_FILE;

class ImageRecolorUsingThreadsTest {
	private BufferedImage originalImage;
	private BufferedImage resultImage;

	@BeforeAll
	static void checkFileExists() {
		// checking the file path
		Path yo = Paths.get("../" + SOURCE_FILE);
		System.out.println(yo.toAbsolutePath());

		assertTrue(Files.exists(yo));
	}

	@BeforeEach
	void loadOriginalImage() throws IOException {
		originalImage = ImageIO.read(new File("../" + SOURCE_FILE));

		resultImage = new BufferedImage(
				originalImage.getWidth(),
				originalImage.getHeight(),
				BufferedImage.TYPE_INT_RGB
		);
	}

	@Test
	void recolorMultiThreaded() {
		// should be the number of cores ?
		int numberOfThreads = 6;

		assertTimeout(Duration.ofMillis(900), () -> {
			ImageRecolorUsingThreads.recolorMultiThreaded(originalImage, resultImage, numberOfThreads);
		});
	}

	@Test
	void recolorSingleThreaded() {
		assertTimeout(Duration.ofMillis(1800), () -> {
			ImageRecolorUsingThreads.recolorSingleThreaded(originalImage, resultImage);
		});
	}
}