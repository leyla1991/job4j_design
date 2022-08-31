package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainJson {

    public static void main(String[] args) {

        JSONObject jsonAuthor = new JSONObject("{\"name\":\"King\"}");


        List<String> list = new ArrayList<>();
        list.add("Horror");
        list.add("Thriller");
        JSONArray jsonStyles = new JSONArray(list);

        final Book book = new Book(true, "It", 1338,
                new String[]{"Horror", "Thriller"},
                new Author("King"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bye", book.isBye());
        jsonObject.put("name", book.getName());
        jsonObject.put("author", jsonAuthor);
        jsonObject.put("style", jsonStyles);
        jsonObject.put("page", 1338);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(book).toString());

    }
}
