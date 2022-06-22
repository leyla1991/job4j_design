package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class RoleStoreTest {

    @Test
    public void whenAddAndFindActorNamePetr() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        Role result = role.findById("1");
        assertThat(result.getActorName(), is("Petr"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        Role result = role.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindActorNameIsPetr() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.add(new Role("1", "Anna"));
        Role result = role.findById("1");
        assertThat(result.getActorName(), is("Petr"));
    }

    @Test
    public void whenReplaceThenActorNameIsAnna() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.replace("1", new Role("1", "Anna"));
        Role result = role.findById("1");
        assertThat(result.getActorName(), is("Anna"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeActorName() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.replace("10", new Role("10", "Anna"));
        Role result = role.findById("1");
        assertThat(result.getActorName(), is("Petr"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.delete("1");
        Role result = role.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenActorNameIsPetr() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.delete("10");
        Role result = role.findById("1");
        assertThat(result.getActorName(), is("Petr"));
    }
}
