package ru.job4j.set;

import java.util.*;


public class User {

   private String name;
   private int children;
   private Calendar birthday;

   public User(String name, int children, Calendar birthday) {
       this.birthday = birthday;
       this.name = name;
       this.children = children;
   }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) {
           return true;
       }
       if (obj == null || getClass() != obj.getClass()) {
           return false;
       }
       User user = (User) obj;
       return name == user.name
               && children == user.children
               && birthday == user.birthday
               && birthday.getTimeInMillis() == user.birthday.getTimeInMillis();
    }

    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * 17 + birthday.hashCode();
        hash = hash * 17 + name.hashCode();
        hash = hash * 17 + children;
        return hash;
    }

    public static void main(String[] args) {
       Calendar date = new GregorianCalendar(2017, 0, 23);
        User user1 = new User("Alex", 2, date);
        User user2 = new User("Alex", 2, date);
        HashMap<User, Object> maps = new HashMap<>();
        maps.put(user1, new Object());
        maps.put(user2, new Object());
        System.out.println(maps.get(user1));
        System.out.println(maps.get(user2));
    }
}
