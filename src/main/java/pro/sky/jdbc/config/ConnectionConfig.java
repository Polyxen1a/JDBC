package pro.sky.jdbc.config;

import com.sun.jdi.connect.spi.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionConfig {

    public static Properties loadProperties(String resourceFileName) throws IOException {

        Properties configuration = new Properties();
        InputStream inputStream = ConnectionConfig.class
                .getClassLoader()
                .getResourceAsStream(resourceFileName);
        configuration.load(inputStream);
        if (inputStream != null) {
            inputStream.close();

        }
        return configuration;
    }

    public static Connection getConnection() {
        Properties properties;
        Connection connection;
        try {
            properties = loadProperties("Application.properties");
            String user = properties.getProperty("datasourse.username");
            String pasw = properties.getProperty("datasourse.password");
            String url = properties.getProperty("datasouse.url");
            connection = DriverManager.getConnection(url, user, pasw);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);

        }
        return connection;
    }

}

