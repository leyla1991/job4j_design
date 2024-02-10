package ru.job4j.ood.lsp.storage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Trash extends AbstractStore {

    @Override
    public int minDate() {
        return 100;
    }

    public int maxDate() {
        return 1000000;
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
