package pro.sky.jdbc;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "postgres";
        final String url = "jdbc:postgresql://localhost:5432/newbase";

        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM employee WHERE id = (?)");

            statement.setInt(1, 1);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = "Name: " + resultSet.getString("first_name");
                String surname = "Surname: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString(4);
                int age = resultSet.getInt(5);

                System.out.println(name);
                System.out.println(surname);
                System.out.println(gender);
                System.out.println("Age: " + age);
            }
        }
    }
}