package ru.job4j.ood.srp;

import java.util.List;

public interface Spell {

    List<String> spells(int size);

    String  generateSpell();

    void castSpell(List<String> spells, int numButton);
}
