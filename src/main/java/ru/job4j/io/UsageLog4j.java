package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        double weight = 72.0;
        float height = 182.3F;
        boolean sport = true;
        byte footSize = 42;
        long days = 12045;
        char firstLetter = 'P';
        short size = 46;
        LOG.debug("User info name: {}, age: {}, weight: {}, height: {}, footSize: {}, sport: {}, days: {}, firstLetter: {}, size: {}",
                name, age, weight, height, footSize, sport, days, firstLetter, size);
    }
}

