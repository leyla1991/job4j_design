package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {

    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Давай поговорим");
        String user = in.nextLine();
        int count = 0;
        List<String> log = new ArrayList<>();
        while (!OUT.equals(user)) {
            if (count == 0) {
                log.add(user);
                String answer = readPhrases().get(new Random().nextInt(readPhrases().size()));
                log.add(answer);
                System.out.println(answer);
                user = in.nextLine();
            }
            if (STOP.equals(user)) {
                log.add(user);
                user = in.nextLine();
                count = 1;

            }
            if (CONTINUE.equals(user) && count == 1) {
                count = 0;
                log.add(user);
                String answer = readPhrases().get(new Random().nextInt(readPhrases().size()));
                log.add(answer);
                System.out.println(answer);
                user = in.nextLine();
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
           list = in.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(
              new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            for (String l : log) {
                out.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j_design\\data\\lvl\\lvl2\\log.txt",  "C:\\projects\\job4j_design\\data\\lvl\\botAnswer.txt");
        cc.run();
    }
}
