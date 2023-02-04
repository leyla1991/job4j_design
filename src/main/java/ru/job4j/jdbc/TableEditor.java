package ru.job4j.jdbc;

import javax.swing.*;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName(properties.getProperty("driver"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws Exception {
        statement(String.format("CREATE TABLE IF NOT EXISTS %s ();", tableName));
    }

    public void dropTable(String tableName) throws Exception {
        statement(String.format("DROP TABLE %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        statement(String.format("ALTER TABLE %s ADD COLUMN %s %s;", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columName) throws Exception {
        statement(String.format("ALTER TABLE %s DROP COLUMN %s ", tableName, columName));
    }

    public void renameColumnName(String tableName, String columnName, String newColumnName) throws Exception {
        statement(String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName));
    }

    private void statement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public String getTableSheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format("select * from %s limit1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n", metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            config.load(in);
            try (TableEditor tableEditor = new TableEditor(config)) {
                tableEditor.createTable("Book");
                System.out.println(tableEditor.getTableSheme("Book"));
                tableEditor.addColumn("Book", "author", "text");
                System.out.println(tableEditor.getTableSheme("Book"));
                tableEditor.renameColumnName("Book", "author", "RENAME");
                System.out.println(tableEditor.getTableSheme("Book"));
                tableEditor.dropColumn("Book", "author");
                System.out.println(tableEditor.getTableSheme("Book"));
                tableEditor.dropTable("Book");
            }
        }
    }

}



