package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {

    public List<String> filter(String file) {
        List<String> list = new ArrayList<>();
       try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
           for (String line = in.readLine(); line != null; line = in.readLine()) {
               String[] lines = line.split(" ");
               if ("404".equals(lines[lines.length - 2])) {
                   list.add(line);
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
        return list;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("404.txt")
                )
        )) {
            for (String l : log) {
                out.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        save(log, "404.txt");
        for (String l : log) {
            System.out.println(l);
        }
    }
}
