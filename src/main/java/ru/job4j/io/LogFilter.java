package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {

    public List<String> filter(String file) {
        List<String> list = new ArrayList<>();
       try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
           for (String line = in.readLine(); line != null; line = in.readLine()) {
               String[] lines = line.split(" ");
                   if (lines[lines.length - 2].equals("404")) {
                       list.add(line);
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
        return list;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        System.out.println(log);

    }
}
