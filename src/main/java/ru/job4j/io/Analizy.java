package ru.job4j.io;
import java.io.*;

public class Analizy {

    public void unavailable(String source, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            BufferedReader read = new BufferedReader(new FileReader(source));
                boolean status = true;
                while (read.ready()) {
                    String line = read.readLine();
                    if (status && line.contains("500") || status && line.contains("400")) {
                        status = false;
                        String[] l = line.split(" ");
                        out.print(l[1] + ";");
                    } else if (!status && line.contains("200") || status && line.contains("300")) {
                        status = true;
                        String[] l = line.split(" ");
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
