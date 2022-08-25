package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (var s : sources) {
                zip.putNextEntry(new ZipEntry(s.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(s.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void validate(ArgsName name) {
        File file = new File(name.get("d"));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exists %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        if (name.get("e").startsWith(".")) {
            throw new IllegalArgumentException("Wrong argument" + name.get("e"));
        }
        if (!name.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("Wrong argument" + name.get("o"));
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 3) {
            ArgsName name = ArgsName.of(args);
            validate(name);
            Zip zip = new Zip();
            Path path = Paths.get(name.get("d"));
            Path out = Paths.get(name.get("o"));
            List<Path> list = Search.search(path, p -> !p.toFile().getName().endsWith(name.get("e")));
            zip.packFiles(list, out.toFile());
        }
    }
}
