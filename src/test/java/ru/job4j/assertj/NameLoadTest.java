package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void nameNotContainSymbol() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("Limit is not"))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void  nameNotContainKey() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=Our name"))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void nameNotContainValue() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("Our name ="))
                .isInstanceOf(IllegalArgumentException.class)
                .message().isNotEmpty();
    }

    @Test
    void checkArraysIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(""))
                .isInstanceOf(IllegalArgumentException.class)
                .message().isNotEmpty();
    }

    @Test
    void checkMessageNotSymbol() {
        NameLoad nameLoad = new NameLoad();
        String name = "Test";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("this name: Test does not contain the symbol \"=\"")
                .hasMessageContaining(name)
                .hasMessageContaining("Test");
    }

    @Test
    void checkMessageNotKey() {
        NameLoad nameLoad = new NameLoad();
        String name = "= Test";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("this name: = Test does not contain a key")
                .hasMessageContaining(name)
                .hasMessageContaining("= Test");
    }

    @Test
    void checkMessageNotValue() {
        NameLoad nameLoad = new NameLoad();
        String name = "Test =";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("this name: Test = does not contain a value")
                .hasMessageContaining(name)
                .hasMessageContaining("Test =");
    }
}