package com.conan2zo.project1.common;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Dummy {

    public static Connection getConnection(){

        Connection con = null;

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/java/com/conan2zo/project1/file"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            Class.forName(driver);
            con = DriverManager.getConnection(url,prop);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

}

