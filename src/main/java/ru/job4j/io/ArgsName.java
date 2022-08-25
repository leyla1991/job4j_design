package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Wrong key");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            validates(s);
            String[] kv = s.replaceFirst("-", "").split("=", 2);
            if (kv.length == 2) {
                values.put(kv[0], kv[1]);
            }
        }

    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Wrong values");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void validates(String arg) {
        if (!arg.contains("=")) {
            throw new IllegalArgumentException("Not found = " + arg);
        }
        if (!arg.startsWith("-")) {
            throw new IllegalArgumentException("Not found - " + arg);
        }
        String[] a = arg.replaceFirst("-", "").split("=", 2);
        if (a[0].isEmpty()) {
            throw new IllegalArgumentException("Not found key " + arg);
        }
        if (a[1].isEmpty()) {
            throw new IllegalArgumentException("Values not found " + arg);
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
