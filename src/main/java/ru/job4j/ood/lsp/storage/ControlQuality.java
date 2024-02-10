package ru.job4j.ood.lsp.storage;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControlQuality {

    public Map<Double, Food> validate(List<Food> foodList, LocalDateTime check) {
        Map<Double, Food> foodMap = new HashMap<>();
        DateCheck dateCheck = new DateCheck();
        for (Food food : foodList) {
            double days = dateCheck.date(food, check);
            foodMap.put(days, food);
            }
        return foodMap;
        }
}

