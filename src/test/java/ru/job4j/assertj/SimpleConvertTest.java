package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;


class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> array = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("first")
                .contains("second")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> stringSet = simpleConvert.toSet("first", "second", "three", "four");
        assertThat(stringSet).hasSize(4)
                .containsExactly("four", "three", "first", "second")
                .contains("first")
                .containsAnyOf("four", "zero", "one")
                .doesNotContain("six", "nine");
    }

    @Test
    void assertMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("1", "2", "2", "3");
        assertThat(map).hasSize(3)
                .containsKeys("1", "2")
                .containsValues(0, 1, 3)
                .doesNotContainKey("4")
                .doesNotContainValue(4)
                .containsEntry("1", 0);
    }
}