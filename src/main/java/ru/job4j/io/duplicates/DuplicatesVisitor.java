package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Map<FileProperty, Path> dublicates = new HashMap<>();
    List<Path>  lists = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(),
                file.toFile().getName());
        if (!dublicates.containsKey(fileProperty)) {
            dublicates.put(fileProperty, file);
        } else {
            lists.add(file);
            System.out.println(file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getLists() {
        return lists;
    }

}
