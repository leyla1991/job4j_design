package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E> {

    transient int size = 0;
    transient Node<E> first;
    private int mobCount;

    public static class Node<E> {

        E item;
        Node<E> next;

        Node(E item) {
            this.item = item;
            next = null;
        }
    }

        @Override
    public void add(E value) {
        Node<E> newNode = new Node<E>(value);
        if (first == null) {
            first = newNode;
        }
        first.next = newNode;
        size++;
        mobCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> getElement = first;
        for (int i = 0; i < index; i++) {
            getElement = getElement.next;
        }
        return getElement.item;
    }

    @Override
    public Iterator<E> iterator() {
         return new Iterator<E>() {
            int mobCountExpect = mobCount;
            Node<E> tmp = first;
            @Override
            public boolean hasNext() {
                if (mobCount != mobCountExpect) {
                throw new ConcurrentModificationException();
            }
                return tmp != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                E val = tmp.item;
                tmp = tmp.next;
                return val;
            }
        };
    }
}
