package GUI.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import GUI.model.DatabaseManager;
import GUI.view.LoginPage;
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

        LoginPage loginView = new LoginPage();
        LoginController loginScene = new LoginController(dbManager, this, loginView);

        mainFrame.addPanel(welcomeView, MainFrame.WELCOME_PAGE);
        mainFrame.addPanel(loginView, MainFrame.LOGIN_PAGE);

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

    public void showLoginPage() {
        mainFrame.showPanel(MainFrame.LOGIN_PAGE);
    }

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("hi")));

        SwingUtilities.invokeLater(() -> new ApplicationController());
    }

}
