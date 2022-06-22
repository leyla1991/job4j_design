package ru.job4j.generics;

public class Role extends Base {

    private final String actorName;


    public Role(String id, String actorName) {
        super(id);
        this.actorName = actorName;
    }

    public String getActorName() {
        return actorName;
    }
}
