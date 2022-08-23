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
                zip.putNextEntry(new ZipEntry(s.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(s.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Not found argument");
        }
        File file = new File(args[0]);
        if (file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
            }
        Zip zip = new Zip();
        ArgsName name = ArgsName.of(args);
        Path path = Paths.get(name.get("d"));
        Path out = Paths.get(name.get("o"));
        List<Path> list = Search.search(path, p -> !p.toFile().getName().endsWith(name.get("e")));
        zip.packFiles(list, out.toFile());
        }


}
