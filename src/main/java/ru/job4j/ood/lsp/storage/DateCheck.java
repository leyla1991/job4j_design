package ru.job4j.ood.lsp.storage;

import java.time.LocalDateTime;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateCheck {

    public double date(Food food, LocalDateTime check) {
        LocalDateTime create = food.getCreate();
        LocalDateTime ex = food.getExpiryDate();
        double difference = (double) DAYS.between(create, ex);
        double diff = (double) DAYS.between(create, check);
        return Math.abs((diff / difference) * 100);
    }
}
