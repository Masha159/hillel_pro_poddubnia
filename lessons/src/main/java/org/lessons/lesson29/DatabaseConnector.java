package org.lessons.lesson29;

import java.sql.*;
import java.util.List;


public class DatabaseConnector {
    static String url = "jdbc:mysql://localhost:3306/company";
    static String username = "myuser";
    static String password = "mypassword";

    public static Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static PreparedStatement createStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public static boolean executeQuery(String sqlQuery, List<Object> params) throws SQLException {
        try (Connection connection = DatabaseConnector.connectToDatabase()) {
            PreparedStatement statement = createStatement(connection, sqlQuery);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            return statement.execute();
        }
    }
}
