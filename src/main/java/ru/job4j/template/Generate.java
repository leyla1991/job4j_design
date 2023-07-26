package ru.job4j.template;

import java.util.Map;

public interface Generate {
    String produce(String template, Map<String, String> args);
}
