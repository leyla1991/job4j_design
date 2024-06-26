package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    @Test
    void whenAddFoodShop() {
        Food food = new Food("Milk",
                LocalDateTime.of(2024, 5, 1, 1, 10),
                LocalDateTime.of(2024, 3, 10, 1, 10),
                130.3D, 0.25D);
        List<Food> foodList = List.of(food);
        AbstractStore shop = new Shop();
        shop.add(foodList);
        assertThat(shop.getFoodList().size()).isEqualTo(1);
        assertThat(shop.getFoodList().get(0).getName()).isEqualTo("Milk");
    }

    @Test
    void whenPriceChange() {
        Food food = new Food("Milk",
                LocalDateTime.of(2024, 5, 20, 1, 10),
                LocalDateTime.of(2024, 3, 10, 1, 10),
                130.3D, 0.25D);
        List<Food> foodList = List.of(food);
        AbstractStore shop = new Shop();
        shop.add(foodList);
        assertThat(shop.getFoodList().get(0).getPrice()).isEqualTo(130.3D);
    }
}
