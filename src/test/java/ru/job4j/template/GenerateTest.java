package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
class GenerateTest {


    @Test
    public void whenProduceDone() {
        Library library = new Library();
        String text = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Power");
        assertThat("I am a Name, Who are Power?")
                .isEqualTo(library.produce(text, map));
    }

    @Test
    public void whenKeyNull() {
        Library library = new Library();
        String text = " ";
        Map<String, String> map = new HashMap<>();
        map.put("Name",
                "power");
        assertThatThrownBy(() -> library.produce(text, map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenKeyExcess() {
        Library library = new Library();
        String text = " ";
        Map<String, String> map = new HashMap<>();
        map.put("Dmitriy", "Garris");
        map.put("Name", "Power");
        map.put("Bond", "James");
        assertThatThrownBy(() -> library.produce(text, map))
                .isInstanceOf(IllegalArgumentException.class);
    }
}