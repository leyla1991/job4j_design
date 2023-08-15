package ru.job4j.ood.ocp;
/*
*Данный класс нарушает принцип OCP так,
* как для его расширения потребуется вносить изменения в сам класс.
* Можно провести рефракторинг кода и создать интерфейс Sound, который можно будет переопределять
* для разных видов животных
 */
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
