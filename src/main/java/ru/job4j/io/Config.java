package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {


    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() throws IllegalArgumentException {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
           in.lines().filter(l -> l.length() > 0 && !l.startsWith("#"))
                   .forEach(s -> {
               String[] key = s.split("=", 2);
               if (key.length != 2 || key[0].isBlank() || key[1].isBlank()) {
                   throw  new IllegalArgumentException("Invalid string: " + s);
               }
               values.put(key[0], key[1]);
                   });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }
}
