package reval.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceUtil {
    static List<Path> getResourceFolderFiles() {
        Path path = Paths.get("src/main/resources");

        List<Path> pathFiles = null;
        try {

            pathFiles = Files.list(path)
                    .filter(Files::isRegularFile)
                    .filter(path1 -> !path1.getFileName().toString().startsWith("."))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pathFiles;
    }

    static Path getResourceFile(String fileName) {

        List<Path> resourceFolderFiles = getResourceFolderFiles();

        return resourceFolderFiles.stream().filter(path -> path.getFileName().toString().contains(fileName)).findAny().orElse(null);
    }
}
