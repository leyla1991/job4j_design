package ru.job4j.ood.lsp.storage;

import org.apache.log4j.helpers.DateTimeDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Food {

    private String name;

    private LocalDateTime expiryDate;

    private LocalDateTime create;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private double price;

    private double discount;

    public Food(String name, LocalDateTime expiryDate, LocalDateTime create, double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.create = create;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("name: %s, expiryDate: %s, create: %s, price: %s",
                name, formatter.format(expiryDate), formatter.format(create), price);
    }
}
