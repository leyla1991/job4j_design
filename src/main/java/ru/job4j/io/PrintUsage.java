package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintUsage {

    public static void main(String[] args) {
        try (PrintStream printStream = new PrintStream(new FileOutputStream("data/print.txt"));
            PrintWriter writer = new PrintWriter("data/write.txt")) {
            printStream.println("Из PrintStream в FileOutputStream");
            printStream.write("New row".getBytes());
            writer.println("New message");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
