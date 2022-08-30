package ru.job4j.serialization.json;

import java.util.Arrays;

public class Book {

    private final boolean bye;
    private final  String name;
    private final int page;
    private final String[] style;
    private final Author author;

    public Book(boolean bye, String name, int page, String[] style, Author author) {
        this.bye = bye;
        this.name = name;
        this.page = page;
        this.style = style;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{"
                + "byeBook=" + bye
                + ", name='" + name + '\''
                + ", page=" + page
                + ", style=" + Arrays.toString(style)
                + ", author=" + author
                + '}';
    }
}
