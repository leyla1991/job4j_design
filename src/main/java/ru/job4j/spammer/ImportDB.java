package ru.job4j.spammer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public  ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
           rd.lines().forEach(s -> {
               String[] lines = s.split(";");
               if (lines.length < 2 || lines[0].isBlank() || lines[1].isBlank()) {
                   throw new IllegalArgumentException("Неверный формат строки");
               }
               users.add(new User(lines[0], lines[1]));
           });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        String url = cfg.getProperty("jdbc.url");
        String username = cfg.getProperty("jdbc.username");
        String pass = cfg.getProperty("jdbc.password");
        try (Connection cnt = DriverManager.getConnection(
                url,
                username,
                pass
        )) {
            try (Statement st = cnt.createStatement()) {
                st.execute(String.format("CREATE TABLE IF NOT EXISTS users(%s, %s, %s)",
                        "id serial primary key",
                        "name varchar(255)",
                        "email text"));
            }
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("INSERT INTO users(name, email) VALUES (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("spammer/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./data/dump.txt");
        db.save(db.load());
    }
}
