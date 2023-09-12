package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenAddFoodShop() {
        Food food = new Food("Milk",
                LocalDateTime.of(2023, 9, 1, 1, 10),
                LocalDateTime.of(2023, 9, 10, 1, 10),
                130.3D, 0.25D);
        LocalDateTime create = food.getCreate();
        LocalDateTime dateEx = food.getExpiryDate();
        LocalDateTime now = LocalDateTime.now();
        double difference = (double) DAYS.between(create, dateEx);
        double diff = (double) DAYS.between(create, now);
        double validate =  (difference / diff) * 100;
        AbstractStore shop = new Shop();
        shop.add(food, validate);
        assertThat(shop.getFoodList().size()).isEqualTo(1);
        assertThat(shop.getFoodList().get(0).getName()).isEqualTo("Milk");
    }

    @Test
    void whenAddFoodTrash() {
        Food food = new Food("Milk",
                LocalDateTime.of(2023, 9, 12, 1, 12),
                LocalDateTime.of(2023, 9, 10, 1, 12),
                130.3D, 0.25D);
        AbstractStore trash = new Trash();
        trash.add(food, 10D);
        assertThat(trash.getFoodList().size()).isEqualTo(1);
    }

    @Test
    void whenAddFoodWareHouse() {
        Food food = new Food("Milk",
                LocalDateTime.of(2023, 9, 30, 1, 12),
                LocalDateTime.of(2023, 8, 1, 1, 12),
                130.3D, 0.25D);
        AbstractStore wareHouse = new Warehouse();
        wareHouse.add(food, 10D);
        assertThat(wareHouse.getFoodList().size()).isEqualTo(1);
    }

    @Test
    void whenAddFoodAll() {
        Food food = new Food("Milk",
                LocalDateTime.of(2023, 9, 13, 1, 12),
                LocalDateTime.of(2023, 9, 10, 1, 12),
                130.3D, 0.25D);
        Food food1 = new Food("Brad",
                LocalDateTime.of(2023, 9, 9, 1, 12),
                LocalDateTime.of(2023, 9, 7, 1, 12),
                154.3D, 0.25D);
        AbstractStore trash = new Trash();
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();

        List<Store> foodList = List.of(trash, shop, wareHouse);
        ControlQuality cr = new ControlQuality(foodList);
        cr.validate(food1);
        cr.validate(food);
        assertThat(trash.getFoodList().size()).isEqualTo(1);
        assertThat(wareHouse.getFoodList().size()).isEqualTo(0);
        assertThat(shop.getFoodList().size()).isEqualTo(1);
        assertThat(trash.getFoodList().get(0).getName()).isEqualTo("Milk");
        assertThat(shop.getFoodList().get(0).getName()).isEqualTo("Brad");
    }
}