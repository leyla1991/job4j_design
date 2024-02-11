package ru.job4j.ood.lsp.parking;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class ControlParkingTest {

    @Test
    void whenAddOneParking() {
        Cars cars = new Truck("truck", 4);
        List<Cars> carsList = new ArrayList<>();
        carsList.add(cars);
        AbstractParking parking = new ControlParking();
        parking.addCar(carsList);
        assertThat(parking.cars.size()).isEqualTo(1);
    }

    @Test
    void whenAddAllParking() {
        Cars cars = new PassengerCar("s", 1);
        Cars cars1 = new Truck("d", 3);
        Cars cars2 = new PassengerCar("l", 1);
        Cars cars3 = new Truck("f", 44);
        List<Cars> carsList = List.of(cars, cars1, cars2, cars3);
        AbstractParking parking = new ControlParking();
        parking.addCar(carsList);
        assertThat(parking.cars.size()).isEqualTo(4);
    }

    @Test
    void whenAddAllAndOneGoAway() {
        Cars cars = new PassengerCar("s", 1);
        Cars cars1 = new Truck("d", 3);
        Cars cars2 = new PassengerCar("l", 1);
        Cars cars3 = new Truck("f", 44);
        Cars cars4 = new Truck("ffsd", 33);
        List<Cars> carsList = List.of(cars, cars1, cars2, cars3, cars4);
        AbstractParking parking = new ControlParking();
        parking.addCar(carsList);
        assertThat(parking.cars.size()).isEqualTo(4);
    }

}