package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        final Book book = new Book(true, "It", 1338,
                new String[]{"Horror", "Thriller"},
                new Author("King"));

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(book));

        final String bookJson =
                "{"
                        + "\"bye\":true,"
                        + "\"name\":\"It\","
                        + "\"page\":1338,"
                        + "\"style\":"
                        + "[\"Horror\", \"Thriller\"],"
                        + "\"author\":"
                        + "{"
                        + "\"name\":\"King\""
                        + "}"
                        + "}";

        final Book bookMod = gson.fromJson(bookJson, Book.class);
        System.out.println(bookMod);
    }
}
