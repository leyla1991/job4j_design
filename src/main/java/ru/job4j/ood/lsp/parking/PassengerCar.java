package ru.job4j.ood.lsp.parking;

import java.util.List;

public class PassengerCar extends Cars {

    public PassengerCar(String name, int size) {
        super(name, size);
        if (size != 1) {
            System.out.println("Размер должен быть равен 1");
        }
    }
}
