package hms.smsApp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class connects to the mysql server and returns a connection object.
 * Created by dasuni on 7/17/15.
 */
public class DBConnection {

    /**
     * Connects to the mysql server and returns sql.Connection object
     * @return Connection object
     */
    public static Connection getConnection() {

        System.out.println("Getting Connection");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is MySQL Driver?");
            e.printStackTrace();
        }
        System.out.println("MySQL Driver connected successfully");
        Connection connection = null;
        try {
            //Connect to the mysql server
            connection = DriverManager.getConnection("jdbc:mysql://localhost/LIBRARY", "root", "");
        } catch (SQLException e) {
            System.out.println("Connection Failed. Check Output Console");
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("You can now control your database");
        } else {
            System.out.println("Failed to make connection");
        }
        return connection;
    }
}
