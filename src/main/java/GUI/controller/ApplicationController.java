package GUI.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import GUI.model.DatabaseManager;
import GUI.model.User;
import GUI.view.HomePage;
import GUI.view.LoginPage;
import GUI.view.MainFrame;
import GUI.view.RegisterPage;
import GUI.view.WelcomePage;

public class ApplicationController {

    private final MainFrame mainFrame;
    private DatabaseManager dbManager;
    private User currentUser;

    HomePage homeView;

    public ApplicationController() {

        setupDatabase();

        this.mainFrame = new MainFrame();

        WelcomePage welcomeView = new WelcomePage();
        WelcomeController welcomeScene = new WelcomeController(dbManager, this, welcomeView);

        LoginPage loginView = new LoginPage();
        LoginController loginScene = new LoginController(dbManager, this, loginView);

        homeView = new HomePage();
        HomeController homeScene = new HomeController(dbManager, this, homeView);

        RegisterPage registerView = new RegisterPage();
        RegisterController registerScene = new RegisterController(dbManager, this, registerView);

        mainFrame.addPanel(welcomeView, MainFrame.WELCOME_PAGE);
        mainFrame.addPanel(loginView, MainFrame.LOGIN_PAGE);
        mainFrame.addPanel(homeView, MainFrame.HOME_PAGE);
        mainFrame.addPanel(registerView, MainFrame.REGISTER_PAGE);

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
        }
    }

    public void showLoginPage() {
        mainFrame.showPanel(MainFrame.LOGIN_PAGE);
    }

    public void showHomePage(User user) {
        currentUser = user;
        homeView.setWelcomeMessage(user);
        mainFrame.showPanel(MainFrame.HOME_PAGE);
    }

    public void showRegisterPage() {
        mainFrame.showPanel(MainFrame.REGISTER_PAGE);
    }

    public void showGoalPage() {
        mainFrame.showPanel(MainFrame.GOAL_PAGE);
    }

    public void showUserInfoPage() {
        mainFrame.showPanel(MainFrame.USER_INFO_PAGE);
    }

    public void showWorkoutHistoryPage() {
        mainFrame.showPanel(MainFrame.WORKOUT_HISTORY_PAGE);
    }

    public void showNewWorkoutPage() {
        mainFrame.showPanel(MainFrame.NEW_WORKOUT_PAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ApplicationController());
    }

}
