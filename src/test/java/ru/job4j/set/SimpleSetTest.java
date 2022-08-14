package ru.job4j.set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
         assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddAll() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(2));
        assertTrue(set.contains(2));
        assertTrue(set.add(3));
        assertTrue(set.contains(3));
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
    }

    @Test
    public void when3Add() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }
}
