package ru.job4j.ood.lsp.storage;

import java.util.List;

public class Shop extends AbstractStore {

    private static final int LAST_DATE = 75;
    @Override
    public int minDate() {
        return 25;
    }

    @Override
    public int maxDate() {
        return 100;
    }

    @Override
    public void add(Food food, double validate) {
        if (validate > LAST_DATE) {
            food.setPrice(food.getPrice() * food.getDiscount());
        }
        super.getFoodList().add(food);
    }
}
