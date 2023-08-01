package ru.job4j.ood.srp;

import java.util.*;

public class Magic implements Spell {


    @Override
    public List<String> spells(int size) {
        List<String> rsl = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            String name = generateSpell();
            if (!rsl.contains(name)) {
                rsl.add(name);
                System.out.println("Spell added to the List");
            }
        }
        return rsl;
    }

    @Override
    public String generateSpell() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void castSpell(List<String> spells, int numButton) {
        if (numButton >= spells.size()) {
            System.out.println("You don't have a spell");
        } else {
            System.out.println(spells.get(numButton));
        }
    }

    public static void main(String[] args) {
        Magic magic = new Magic();
        List<String> list = magic.spells(3);
        magic.castSpell(list, 2);
    }
}
