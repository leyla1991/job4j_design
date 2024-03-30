package ru.job4j.ood.dip;

public class Book {
    public String text;
    public ConsolePrinter consolePrinter;

    public void printer() {
        consolePrinter.print(text);
    }
}
