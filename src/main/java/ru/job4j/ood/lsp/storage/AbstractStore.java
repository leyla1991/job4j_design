package ru.job4j.ood.lsp.storage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected List<Food> foodList = new ArrayList<>();
    public static final int LAST_DATE = 75;
    @Override
    public abstract int minDate();

    @Override
    public abstract int maxDate();


    @Override
    public abstract void add(List<Food> foodList);

    public List<Food> getFoodList() {
        return foodList;
    }

}
