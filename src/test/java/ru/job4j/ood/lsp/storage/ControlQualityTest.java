package ru.job4j.ood.lsp.storage;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    public List<Food> foods = new ArrayList<>();

    public void addFoods() {
        Food food = new Food("Milk",
                LocalDateTime.of(2024, 3, 13, 1, 12),
                LocalDateTime.of(2024, 3, 10, 1, 12),
                130.3D, 0.25D);
        Food food1 = new Food("Brad",
                LocalDateTime.of(2024, 4, 10, 1, 12),
                LocalDateTime.of(2024, 3, 10, 1, 12),
                154.3D, 0.25D);
        Food food2 = new Food("Honey",
                LocalDateTime.of(2024, 5, 1, 1, 12),
                LocalDateTime.of(2024, 3, 26, 1, 12),
                144D, 0.23D);
        foods.add(food);
        foods.add(food1);
        foods.add(food2);
    }

    @Test
    void whenAddFoodAll() {
        addFoods();
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


    @Test
    public void whenResortStores() {
        addFoods();
        foods.add(3, new Food("Jam",
                LocalDateTime.of(2024, 3, 4, 21, 2),
                LocalDateTime.of(2024, 6, 3, 22, 2),
                1D, 0.24D));
        List<Store> stores = List.of(new Shop(), new Trash(), new Warehouse());
        ControlQuality cq = new ControlQuality(stores);
        stores.get(0).add(foods);
        stores.get(1).add(foods);
        stores.get(2).add(foods);
        cq.resort(LocalDateTime.of(2024, 2, 3, 17, 29));
        assertThat(stores.get(0).getFood().get(0).getName()).isEqualTo("Jam");
        assertThat(stores.get(1).getFood().get(0).getName()).isEqualTo("Milk");
        assertThat(stores.get(2).getFood().get(0).getName()).isEqualTo("Honey");
        assertThat(stores.get(0).getFood().get(1).getName()).isEqualTo("Brad");
    }
}






