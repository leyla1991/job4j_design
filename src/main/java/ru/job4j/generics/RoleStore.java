package ru.job4j.generics;

public class RoleStore implements Store<Role> {

    private final Store<Role> film = new MemStore<>();

    @Override
    public void add(Role model) {
        film.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return film.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return film.delete(id);
    }

    @Override
    public Role findById(String id) {
        return film.findById(id);
    }
}
