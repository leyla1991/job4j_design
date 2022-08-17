package ru.job4j.io;

import java.io.File;
import java.io.FileNotFoundException;

public class Dir {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        for (File subfile : file.listFiles()) {
            System.out.printf("%s - %d%n", subfile.getAbsoluteFile(), subfile.getAbsoluteFile().length());
        }
    }
}
