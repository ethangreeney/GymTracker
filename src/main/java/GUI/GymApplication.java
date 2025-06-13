package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GymApplication {

    public static void main(String[] args) {

        Connection dbConnection = null;
        try {

            String dbURL = "jdbc:derby:gymDB;create=true";
            dbConnection = DriverManager.getConnection(dbURL);
            System.out.println("Connected to database successfully.");

            DatabaseManager dbManager = new DatabaseManager(dbConnection);
            dbManager.setupTables(dbConnection);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (dbConnection != null && !dbConnection.isClosed()) {

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}