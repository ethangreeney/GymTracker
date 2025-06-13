package GUI.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import GUI.model.DatabaseManager;
import GUI.view.MainFrame;
import GUI.view.WelcomePage;

public class ApplicationController {
    private MainFrame mainFrame;
    private DatabaseManager dbManager;

    public ApplicationController() {

        setupDatabase();

        this.mainFrame = new MainFrame();

        WelcomePage welcomeView = new WelcomePage();
        WelcomeController welcomeScene = new WelcomeController(dbManager, this, welcomeView);

        mainFrame.addPanel(welcomeView);

        mainFrame.showPanel(MainFrame.WELCOME_PAGE);
        mainFrame.setVisible(true);

    }

    private void setupDatabase() {
        try {
            String dbURL = "jdbc:derby:gymDB;create=true";
            Connection dbConnection = DriverManager.getConnection(dbURL);
            System.out.println("Connected to database successfully.");

            this.dbManager = new DatabaseManager(dbConnection);
            this.dbManager.setupTables(dbConnection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("hi")));

        SwingUtilities.invokeLater(() -> new ApplicationController());
    }

}
