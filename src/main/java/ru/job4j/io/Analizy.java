package ru.job4j.io;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Analizy {

    public void unavailable(String source, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target));
            BufferedReader read = new BufferedReader(new FileReader(source))) {
            boolean status = true;
                while (read.ready()) {
                    String line = read.readLine();
                    String[] l = line.split(" ");
                    if (status && (l[0].startsWith("500") || l[0].startsWith("400"))) {
                        status = false;
                        out.print(l[1] + ";");
                    }
                    if (!status && (l[0].startsWith("200") || l[0].startsWith("300"))) {
                        status = true;
                        out.println(l[1] + System.lineSeparator());
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Analizy().unavailable("server.log", "unavailable.csv");
    }
}
