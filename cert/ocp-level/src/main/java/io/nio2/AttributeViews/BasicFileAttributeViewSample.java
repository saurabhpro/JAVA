package io.nio2.AttributeViews;

import io.FilePaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributeViewSample {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get(FilePaths.BASE_RELATIVE_PATH + "log.txt");

		BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);

		BasicFileAttributes data = view.readAttributes();

		FileTime lastModifiedTime = FileTime.fromMillis(data.lastModifiedTime().toMillis() + 10_000);
		view.setTimes(lastModifiedTime, null, null);    // only update method in BasicFileAttributeView class

		//Path path = Paths.get("sloth.schedule");
		BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
		if (attributes.size() > 0 && attributes.creationTime().toMillis() > 0) {
			//attributes.setTimes(null, null, null);
		}

	}
}