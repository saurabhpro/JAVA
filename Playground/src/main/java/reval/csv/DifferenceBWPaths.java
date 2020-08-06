package reval.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static reval.csv.ResourceUtil.getResourceFolderFiles;

public class DifferenceBWPaths {

    public static void main(String[] args) {
        List<Path> pathListForCsvFiles = getResourceFolderFiles();
        pathListForCsvFiles.forEach(path -> {
            System.out.println("\n\n>>>>>> " + path.getFileName() + "<<<<<<<<");
            try {
                Set<String> oldConfiguration = Files.lines(path)
                        .map(str -> DifferenceBWPaths.mapToItem(str, 0))
                        .filter(str -> !str.isBlank())
                        .collect(Collectors.toSet());
                Set<String> newConfiguration = Files.lines(path)
                        .map(str -> DifferenceBWPaths.mapToItem(str, 1))
                        .filter(str -> !str.isBlank())
                        .collect(Collectors.toSet());

                Set<String> deleted = oldConfiguration.stream()
                        .filter(config -> !newConfiguration.contains(config))
                        .collect(Collectors.toCollection(TreeSet::new));
                Set<String> added = newConfiguration.stream()
                        .filter(config -> !oldConfiguration.contains(config))
                        .collect(Collectors.toCollection(TreeSet::new));

                System.out.println("deleted - " + deleted.size());
                deleted.forEach(System.out::println);
                System.out.println("\nadded - " + added.size());
                added.forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private static String mapToItem(String line, Integer column) {
        //It's a BOM, which technically is not needed for utf-8 but M$ (notepad?) had the idea to put it there anyway to indicate encoding
        //Use encoding='utf-8-sig' when opening (that will just ignore it for you). See also https://docs.python.org/2/library/codecs.html#encodings-and-unicode

        String[] p = line.replace("\uFEFF", "").split(",");// a CSV has comma separated lines
        if (p[column] == null || "NULL".equals(p[column])) {
            p[column] = "";
        }
        return p[column].strip();
    }
}
