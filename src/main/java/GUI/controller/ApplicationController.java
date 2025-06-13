package GUI.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sound.sampled.SourceDataLine;
import javax.swing.SwingUtilities;

import GUI.model.DatabaseManager;
import GUI.view.MainFrame;

public class ApplicationController {
    private MainFrame mainFrame;
    private DatabaseManager dbManager;

    public ApplicationController() {

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

        WelcomeController welcomeScene = new WelcomeController(dbManager, new WelcomePage, this);

        this.mainFrame = new MainFrame();
        mainFrame.setVisible(true);

    }

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("hi")));

        SwingUtilities.invokeLater(() -> new ApplicationController());
    }

}
