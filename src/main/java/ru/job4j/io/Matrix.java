package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Matrix {

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("multiple.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int x = 1; x < 10; x++) {
                     out.write(((i * x) + " ").getBytes(StandardCharsets.UTF_8));
                }
                out.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
