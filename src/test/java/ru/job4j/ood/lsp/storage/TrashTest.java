package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.assertj.core.api.Assertions.*;

public class TrashTest {

    @Test
    void whenAddFoodTrash() {
        Food food = new Food("Milk",
                LocalDateTime.of(2023, 9, 12, 1, 12),
                LocalDateTime.of(2023, 9, 10, 1, 12),
                130.3D, 0.25D);
        List<Food> foodList = new ArrayList<>();
        foodList.add(food);
        AbstractStore trash = new Trash();
        trash.add(foodList);
        assertThat(trash.getFoodList().size()).isEqualTo(1);
    }
}
