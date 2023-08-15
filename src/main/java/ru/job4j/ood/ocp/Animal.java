package ru.job4j.ood.ocp;

public class Animal {

    private class SoundCat {
        public void sound() {
            System.out.println("Мяу");
        }
    }

    private class SoundDog {
        public void sound() {
            System.out.println("Гав");
        }
    }
}
