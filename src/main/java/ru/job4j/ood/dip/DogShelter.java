package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

public class DogShelter {

    private Poodle poodle;
    private Terier terier;
    List<Dog> dogList = new ArrayList<>();

    public DogShelter(Poodle poodle, Terier terier) {
        DogShelter dogShelter = new DogShelter(new Poodle(), new Terier());
        dogShelter.terier.sound();
        dogList.add(dogShelter.terier);
    }

}
