package ru.job4j.ood.lsp.storage;

import java.util.List;

public class Warehouse extends AbstractStore {

    @Override
    public int minDate() {
        return 0;
    }

    @Override
    public int maxDate() {
        return 25;
    }

    @Override
    public void add(Food food, double validate) {
        super.getFoodList().add(food);
    }
}


