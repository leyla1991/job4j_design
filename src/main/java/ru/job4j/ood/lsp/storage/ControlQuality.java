package ru.job4j.ood.lsp.storage;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }


    private double date(Food food) {
        LocalDateTime create = food.getCreate();
        LocalDateTime ex = food.getExpiryDate();
        LocalDateTime now = LocalDateTime.now();
        double difference = (double) DAYS.between(create, ex);
        double diff = (double) DAYS.between(create, now);
        return (difference / diff) * 100;
    }

    public void validate(Food food) {
        double days = date(food);
        for (Store store : stores) {
            if (days > store.minDate() && days <= store.maxDate()) {
                store.add(food, days);
            }
        }
    }

}
