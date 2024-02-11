package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Parking {


    int freeCount();
    public void addCar(List<Cars> cars);
}
