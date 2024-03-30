package ru.job4j.ood.lsp.storage;

import java.time.LocalDateTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public ControlQuality() {

    }
    public Map<Double, Food> validate(List<Food> foodList, LocalDateTime check) {
        Map<Double, Food> foodMap = new HashMap<>();
        DateCheck dateCheck = new DateCheck();
        for (Food food : foodList) {
            double days = dateCheck.date(food, check);
            foodMap.put(days, food);
            }
        return foodMap;
        }

        public void resort(LocalDateTime newDate) {
            List<Food> foods = new ArrayList<>();
            for (Store store : stores) {
                List<Food> foodList = store.getFood();
                foods.addAll(foodList);
                foodList.clear();
            }
            stores.forEach(store -> store.add(foods));
        }
}

