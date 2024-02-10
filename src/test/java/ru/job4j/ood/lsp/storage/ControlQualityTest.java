package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenAddFoodAll() {
        List<Food> foods = new ArrayList<>();
        Food food = new Food("Milk",
                LocalDateTime.of(2024, 1, 13, 1, 12),
                LocalDateTime.of(2024, 1, 10, 1, 12),
                130.3D, 0.25D);
        Food food1 = new Food("Brad",
                LocalDateTime.of(2024, 3, 10, 1, 12),
                LocalDateTime.of(2024, 1, 10, 1, 12),
                154.3D, 0.25D);
        Food food2 = new Food("Honey",
                LocalDateTime.of(2024, 4, 1, 1, 12),
                LocalDateTime.of(2024, 2, 6, 1, 12),
                144D, 0.23D);
        foods.add(food);
        foods.add(food1);
        foods.add(food2);
        AbstractStore trash = new Trash();
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();
        trash.add(foods);
        shop.add(foods);
        wareHouse.add(foods);
        assertThat(trash.getFoodList().size()).isEqualTo(1);
        assertThat(wareHouse.getFoodList().size()).isEqualTo(1);
        assertThat(shop.getFoodList().size()).isEqualTo(1);
        assertThat(trash.getFoodList().get(0).getName()).isEqualTo("Milk");
        assertThat(shop.getFoodList().get(0).getName()).isEqualTo("Brad");
        assertThat(wareHouse.getFoodList().get(0).getName()).isEqualTo("Honey");
    }
}






