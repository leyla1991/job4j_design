package ru.job4j;

import java.nio.charset.Charset;

public class Tasks {
    public static String collect(String s) {

        char[] c = new char[s.split(" ").length];
        int i = 0;
        for (char c1 : s.toCharArray()) {
            if (Character.isUpperCase(c1)) {
                c[i] = c1;
                i++;
        }

        }
       s = String.valueOf(c);

        return s;
    }
}
