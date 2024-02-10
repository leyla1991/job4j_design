package ru.job4j.ood.lsp.storage;

import java.time.LocalDateTime;
import java.util.*;


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
    public void add(List<Food> foodList) {
        ControlQuality cr = new ControlQuality();
        Map<Double, Food> rsl = cr.validate(foodList, LocalDateTime.now());
        for (Map.Entry<Double, Food> s : rsl.entrySet()) {
            if (s.getKey() > minDate() && s.getKey() <= maxDate()) {
                super.getFoodList().add(s.getValue());
            }
        }
    }
}


