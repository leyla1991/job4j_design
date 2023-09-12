package ru.job4j.ood.lsp.storage;

import java.util.List;

public interface Store {

    void add(Food food, double validate);

    int minDate();

    int maxDate();

}
