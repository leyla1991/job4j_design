package ru.job4j.collection;

import java.util.*;


public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
           container = grow();
           modCount++;
        }
        container[size] = value;
        modCount++;
        size++;
    }

    public T[] grow() {
        return Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public T set(int index, T newValue) {
        T setValue = get(index);
        Objects.checkIndex(index, container.length);
        container[index] = newValue;
        return setValue;
    }

    @Override
    public T remove(int index) {
        T removedEl = get(index);
        if (size - 1 > index) {
            System.arraycopy(container, index + 1, container, index,
                    container.length - index - 1);
        }
        container[container.length - 1] = null;
        size--;
        modCount++;
        return removedEl;

    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            int value = 0;
            @Override
            public boolean hasNext() {

                return value < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[value++];
            }

        };
    }
}
