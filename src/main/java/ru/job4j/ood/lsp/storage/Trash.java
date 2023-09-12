package ru.job4j.ood.lsp.storage;

import java.util.List;

public class Trash extends AbstractStore {

    @Override
    public int minDate() {
        return 100;
    }

    public int maxDate() {
        return 1000;
    }

    @Override
    public void add(Food food, double validate) {
        super.getFoodList().add(food);
    }
}
