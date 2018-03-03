package io.nio2;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsIn {
	public static void main(String[] args) throws URISyntaxException {

		Path path1 = Paths.get("pandas/cuddly.png");
		Path path2 = Paths.get("pandas", "cuddly.png");
		System.out.println(path2);

		// This allows you to create a Path from a list of String values in which the
		// operating system-dependent path.separator is automatically inserted between elements.
		Path path4 = Paths.get("/home/zoodirector");
		Path path5 = Paths.get("/", "home", "zoodirector");
		System.out.println(path5);
		Path path6 = Paths.get("c:", "zooinfo", "November", "employees.txt");
		System.out.println(path6.toAbsolutePath());

		try {
			Path path3 = Paths.get(new URI("file://pandas/cuddly.png")); // THROWS EXCEPTION // AT RUNTIME
		} catch (URISyntaxException | IllegalArgumentException e) {
			System.err.println("URI is not absolute!");
		}

		Path path7 = Paths.get(new URI("file:///home/zoodirectory"));
		Path path8 = Paths.get(new URI("file:///c:/zoo-info/November/employees.txt"));

		Path path9 = Paths.get(new URI("http://www.wiley.com"));
		Path path10 = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));
		URI uri4 = path9.toUri();


		Path path11 = FileSystems.getDefault().getPath("pandas/cuddly.png");
		System.out.println(path11);
		Path path12 = FileSystems.getDefault().getPath("c:", "zooinfo", "November", "employees.txt");
		System.out.println(path12);
		Path path13 = FileSystems.getDefault().getPath("/home/zoodirector");

		// the FileSystems factory class does give us the ability to connect to a remote  le system
		FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));
		Path path14 = fileSystem.getPath("duck.txt");

		File file = new File("pandas/cuddly.png");
		Path path = file.toPath();

		Path path0 = Paths.get("cuddly.png");
		File file0 = path.toFile();


		Paths.get("/zoo/../home").getParent().normalize().toAbsolutePath();

	}
}
