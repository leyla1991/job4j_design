package ru.job4j.ood.ocp;
/*
* Данный класс нарушает принцип OCP тем,
* что если потребуется добавить еще языков для перевода
* придется изменять класс и добавлять еще методы.
* Чтобы избежать этого можно создать интерфейс или абстракцию.
 */
public class Translate {

    public void languageEnglish() {
        System.out.println("Translate into English");
    }

    public void languageFrance() {
        System.out.println("Traduisez en Francais");
    }
}














