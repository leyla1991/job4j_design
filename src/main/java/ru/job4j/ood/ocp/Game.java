package ru.job4j.ood.ocp;


public class Game {

    /*
    * Данный класс нарушает прицип OCP.
    * Для правильной реализации можно использовать наследование,
    * класс NotPlay наследует класс PlayGame и переопределяет метод play;
     */

    private static class PlayGame {
        public String play() {
            return "Come on";
        }
    }
    private static class NotPlay {
        public String notPlay() {
            return "Stop";
        }
    }
}
