package ru.job4j.iterator;

import ru.job4j.serialization.json.A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {

    public static void split(List<ArrayList<Integer>> nudes, Iterator<Integer> source) {
        int index = 0;
        while (source.hasNext()) {
             nudes.get(index++).add(source.next());
             if (index >= nudes.size()) {
                index = 0;
            }
        }
    }
}
