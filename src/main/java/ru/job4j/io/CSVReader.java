package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class CSVReader {

    public static void handle(ArgsName argsName) throws Exception {
        validate(argsName);
        Path path = Path.of(argsName.get("path"));
        var delimiter = argsName.get("delimiter");
        var out = argsName.get("out");
        String[] filter = argsName.get("filter").split(",");
        StringBuilder fileAll = new StringBuilder();
        int[] index = new int[filter.length];
        try (Scanner scanner = new Scanner(path)
                .useDelimiter(System.lineSeparator())) {
            while (scanner.hasNext()) {
                String[] strings = scanner.nextLine().split(delimiter);
                for (int y = 0; y < filter.length; y++)  {
                    for (int i = 0; i < strings.length; i++) {
                        if (filter[y].equals(strings[i])) {
                            index[y] = i;
                            break;
                        }
                    }
                }
                for (int i : index) {
                    fileAll.append(strings[i]).append(delimiter);
                }
                fileAll.deleteCharAt(fileAll.length() - 1)
                        .append(System.lineSeparator());
            }
        }
        outFile(out, fileAll);
    }

    public static void validate(ArgsName argsName) {
        if (!";".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException("Wrong argument");
        }

        if (argsName.get("filter").length() == 0) {
            throw new IllegalArgumentException("Null filter %s" + argsName.get("filter"));
        }
    }

    public static void outFile(String out, StringBuilder stringBuilder) {
        if (out.contains("stdout")) {
            System.out.println(stringBuilder);
        } else {
            try (PrintWriter outFile = new PrintWriter(
                    new FileWriter(out))) {
                outFile.write(String.valueOf(stringBuilder));
                System.out.println("Data has been read file");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName name = new ArgsName();
        handle(name);
    }
}
