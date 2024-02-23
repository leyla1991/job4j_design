package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParking implements Parking {

    public List<Cars> getCars() {
        return cars;
    }

    public static final int COUNTING = 50;
    public int getCounting;
    protected List<Cars> cars = new ArrayList<>();

    @Override
    public int freeCount() {
        return COUNTING - getCounting;
    }

    @Override
    public abstract void addCar(List<Cars> cars);
}

