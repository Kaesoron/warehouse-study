package org.kaesoron.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static final String username = "root";
    public static final String password = "root";
    public static final String url = "jdbc:mysql://localhost:3306/warehouse";
    public static Statement statement;
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
