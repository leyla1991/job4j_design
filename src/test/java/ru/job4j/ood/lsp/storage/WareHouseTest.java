package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class WareHouseTest {

    @Test
    void whenAdd() {
        Food food = new Food("Milk",
                LocalDateTime.of(2024, 5, 30, 1, 12),
                LocalDateTime.of(2024, 3, 25, 1, 12),
                130.3D, 0.25D);
        List<Food> foodList = List.of(food);
        AbstractStore wareHouse = new Warehouse();
        wareHouse.add(foodList);
        assertThat(wareHouse.getFoodList().size()).isEqualTo(1);
    }

}
