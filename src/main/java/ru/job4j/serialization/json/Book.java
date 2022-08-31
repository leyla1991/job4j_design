package ru.job4j.serialization.json;

import java.util.Arrays;

public class Book {

    private boolean bye;
    private  String name;
    private int page;
    private String[] style;
    private Author author;

    public boolean isBye() {
        return bye;
    }

    public String getName() {
        return name;
    }

    public int getPage() {
        return page;
    }

    public String[] getStyle() {
        return style;
    }

    public Author getAuthor() {
        return author;
    }

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
