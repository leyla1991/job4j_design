import java.io.*;
import java.util.*;

public class RandomADM {


    public Random random = new Random();


    public List<String> randoms(Map<Integer, String> names) {
        List<String> rsl = new ArrayList<>();
        while (rsl.size() != names.size()) {
            for (Map.Entry<Integer, String> s : names.entrySet()) {
                int check = random.nextInt(names.size());
                if (s.getKey() == check && !rsl.contains(s.getValue())) {
                    rsl.add(s.getValue());
                }
            }
        }
        return rsl;
    }

    public List<String> randoms1(List<String> names) {
        List<String> rsl = Arrays.asList(new String[names.size()]);
        List<String> remover = new ArrayList<>(names);
        while (remover.size() != 0) {
            int i = random.nextInt(names.size());
            for (String s : names) {
                if (!rsl.contains(s) && rsl.get(i) == null) {
                    rsl.set(i, s);
                    remover.remove(s);
                    i = random.nextInt(names.size());
                }

            }
        }
        return rsl;
    }

    public void writeList(List<String> names, String path) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            for (String s : names) {
                out.write(s + " ");
                out.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> stringList() {
        List<String> listNames = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("data/listNames.txt"))) {
            while (in.ready()) {
                String l = in.readLine();
                listNames.add(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listNames;
    }

    public static void main(String[] args) {
        RandomADM randomADM = new RandomADM();
        Map<Integer, String> names = new HashMap<>() {{
            put(1, "@lub_oww");
                    put(1, "@Katenashn");
                    put(2, "@elekane");
                    put(3, "@Erestnica");
                    put(4,  "@magfafnir");
                    put(5, "@anfisashabat");
                    put(6, "@NataliD1311");
                    put(7, "@dzira92");
                    put(8, "8911 003 2047");
                    put(9, "@Lamia_Ghost");
                    put(10, "@Vasilisk_in");
                    put(11, "@Sizalina");
                    put(12, "@Jester_ios");
                    put(13, "@Kseniya_SUNdueva");
                    put(14, "@jazazar");
                    put(15, "@le_raduga");
                    put(16, "Anastasia K");
                    put(17, "@faithcontrol");
                    put(18,  "мой айди");
                    put(19, "@Akio13579)");
        }};


        List<String> strings = List.of("Диана по кз да",
"Борис",
        "Анфиса Шабат готова на кз",
        "Елена",
"Екатерина",
"Джерри",
"Кирилл Г",
"Юля");

        List<String> string = randomADM.randoms1(strings);
        List<String> stringList = randomADM.randoms1(randomADM.stringList());
        randomADM.writeList(stringList, "data/random.txt");

        for (String s : stringList) {
            System.out.println(s);
        }

    }
}
