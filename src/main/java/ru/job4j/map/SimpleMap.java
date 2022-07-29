package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (((float) count / (float) capacity) >= LOAD_FACTOR) {
            count = 0;
            modCount = 0;
            expand();
        }
        int hash = key == null ? 0 : hash(key.hashCode());
        int index = indexFor(hash);
        boolean rsl = false;
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = table;
        table = new MapEntry[capacity * 2];
        for (MapEntry<K, V> el : newTable) {
            if (el != null) {
                this.put(el.key, el.value);
            }
        }
    }

    @Override
    public V get(K key) {
        for (MapEntry<K, V> v: table) {
            if (v != null && v.key == key
                    || v != null
                    && key != null
                    && v.key != null && v.key.hashCode() == key.hashCode() && key.equals(v.key)) {
                return v.value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && key == table[i].key
                    || table[i] != null && key != null && table[i].key.hashCode() == key.hashCode() && table[i].key.equals(key)) {
                table[i] = null;
                count--;
                modCount--;
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int expectedNow = modCount;
            int index = 0;
            public boolean hasNext() {
                if (modCount != expectedNow) {
                    throw new ConcurrentModificationException();
                }
                while (table.length > index && table[index] == null) {
                    index++;
                }
                return index < table.length && table[index] != null;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
