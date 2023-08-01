package ru.job4j.ood.srp;

import java.util.List;

public interface Spell<T> {

    List<T> spells(int size);

    void readSpell(List<T> spells);

    void castSpell(List<T> spells, int numButton);
}
