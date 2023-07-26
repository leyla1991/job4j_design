package ru.job4j.template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

class GenerateTest {
    private Library library = new Library();
    @Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
    @Test
    public void whenProduceDone() {
        String text = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Power");
        assertThat("I am a Name, Who are Power?")
                .isEqualTo(library.produce(text, map));
    }

    @Test
    public void whenKeyNull() {
        String text = " ";
        Map<String, String> map = new HashMap<>();
        map.put("Name",
                "power");
        assertThatThrownBy(() -> library.produce(text, map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenKeyExcess() {
        String text = " ";
        Map<String, String> map = new HashMap<>();
        map.put("Dmitriy", "Garris");
        map.put("Name", "Power");
        map.put("Bond", "James");
        assertThatThrownBy(() -> library.produce(text, map))
                .isInstanceOf(IllegalArgumentException.class);

    }
}