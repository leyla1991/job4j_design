package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Config config = new Config(Objects.requireNonNull(ConnectionDemo.class.getClassLoader().getResource("app.properties")).getPath());
        config.load();
        Class.forName(config.value("driver"));
        String url = config.value("url");
        String username = config.value("login");
        String pass = config.value("password");
        try (Connection connection = DriverManager.getConnection(url,
                username, pass)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
