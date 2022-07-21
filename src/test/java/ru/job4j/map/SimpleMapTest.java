package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleMapTest {

    @Test
    public void whenPut() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(3, "hot");
        map.put(2, "long");
        String result = map.get(3);
        assertThat(result, is("hot"));
    }

    @Test
    public void whenPut2() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(3, "hot");
        map.put(2, "hot");
        Assert.assertNull(map.get(1));
    }

    @Test
    public void whenPutCopy() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(3, "hot");
        map.put(2, "hot");
        Assert.assertFalse(map.put(3, "hot"));
    }

    @Test
    public void whenRemove() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(3, "chill");
        map.put(1, "little");
        map.put(2, "skin");
        Assert.assertTrue(map.remove(2));
        Assert.assertNull(map.get(2));
    }

    @Test
    public void whenKeyIsNotFindForRemove() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(2, "list");
        Assert.assertFalse(map.remove(1));
    }

    @Test
    public void whenGetNotFind() {
        SimpleMap<Integer, Integer> map = new SimpleMap<>();
        Assert.assertNull(map.get(1));
    }
}

