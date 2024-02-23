package ru.job4j.ood.lsp.parking;

import java.util.List;

public class ControlParking extends AbstractParking {
    @Override
    public void addCar(List<Cars> cars) {
        for (Cars car : cars) {
            if (freeCount() >= car.getSize()) {
                super.getCars().add(car);
                getCounting += car.getSize();
            } else {
                System.out.println("Мест нет, ищите другую парковку");
            }
        }
    }


}
