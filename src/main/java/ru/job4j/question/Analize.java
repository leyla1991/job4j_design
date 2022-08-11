package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        for (User p : previous) {
            Map<Integer, String> curr = current.stream().collect(Collectors.toMap(User::getId, User::getName));

            if (curr.containsKey(p.getId()) && !p.getName().equals(curr.get(p.getId()))) {
                info.setChanged(+1);
            }
            if (previous.size() > curr.size() || !curr.containsKey(p.getId())) {
                info.setDeleted(+1);
            }
        }
        info.setAdded(current.size() - (previous.size() - info.getDeleted()));
        return info;
    }
}
