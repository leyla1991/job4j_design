package ru.job4j.ood.lsp.storage;

import java.util.List;

public interface Store {

    void add(List<Food> foodList);

    int minDate();

    int maxDate();

    List<Food> getFood();

}
