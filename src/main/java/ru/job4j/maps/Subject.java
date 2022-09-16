package ru.job4j.maps;

import java.util.Objects;

public record Subject(String name, int score) {

    @Override
    public String name() {
        return name;
    }

    @Override
    public int score() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
