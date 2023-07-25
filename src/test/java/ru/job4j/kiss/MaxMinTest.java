package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MaxMinTest {

    @Test
    void max() {
        List<String> rsl = new ArrayList<>();
        rsl.add("petrov");
        rsl.add("alliosha");
        rsl.add("lokhkgf");
        rsl.add("future");
        MaxMin max1 = new MaxMin();
        Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length();
        Assert.assertEquals(rsl.get(1), max1.max(rsl, comparator));
    }

    @Test
    void min() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4354);
        list.add(3232);
        MaxMin min1 = new MaxMin();
        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
        Assert.assertEquals(list.get(0), min1.min(list, comparator));
    }

    @Test
    void whenValueNull() {
        List<Integer> rsl = new ArrayList<>();
        MaxMin val = new MaxMin();
        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
        Assert.assertEquals(null, val.max(rsl, comparator));
    }
}