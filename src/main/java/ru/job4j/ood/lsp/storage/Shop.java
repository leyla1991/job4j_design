package ru.job4j.ood.lsp.storage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Shop extends AbstractStore {


    @Override
    public int minDate() {
        return 25;
    }

    @Override
    public int maxDate() {
        return 100;
    }

    @Override
    public void add(List<Food> foodList) {
        ControlQuality cr = new ControlQuality();
        Map<Double, Food> rsl = cr.validate(foodList, LocalDateTime.now());
        for (Map.Entry<Double, Food> s : rsl.entrySet()) {
            if (s.getKey() > LAST_DATE) {
                s.getValue().setPrice(s.getValue().getPrice() - (s.getValue().getPrice()) * s.getValue().getDiscount());
            }
            if (s.getKey() > minDate() && s.getKey() <= maxDate()) {
                super.getFoodList().add(s.getValue());
            }
        }
    }
}
