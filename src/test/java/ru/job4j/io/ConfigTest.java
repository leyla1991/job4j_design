package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairComment() {
        String path = "./data/pair_comment.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenPairWrongComment() {
        String path = "./data/pair_wrong_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("number")).isEqualTo("79999=");
    }

    @Test
    void whenPairWithoutKey() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        assertThatThrownBy((config::load))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenNoSign() {
        String path = "./data/no_sign.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class);
    }
}