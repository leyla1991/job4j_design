package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractParking implements Parking {

    public List<Cars> getCars() {
        return cars;
    }

    public int COUNTING = 50;
    public int COUNTING_OCCUPIED;
    protected List<Cars> cars = new ArrayList<>();

    @Override
    public int freeCount() {
        return COUNTING - COUNTING_OCCUPIED;
    }

    @Override
    public abstract void addCar(List<Cars> cars);
}

