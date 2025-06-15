package GUI.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.SwingUtilities;

import GUI.model.DatabaseManager;
import GUI.model.User;
import GUI.view.HomePage;
import GUI.view.LoginPage;
import GUI.view.LoginPageInterface;
import GUI.view.MainFrame;
import GUI.view.RegisterPage;
import GUI.view.RegisterPageInterface;
import GUI.view.WelcomePage;
import GUI.view.WorkoutPage;
import GUI.view.WorkoutPageInterface;

public class ApplicationController {

    private final MainFrame mainFrame;
    private DatabaseManager dbManager;
    private User currentUser;

    HomePage homeView;
    RegisterPage registerView;
    LoginPage loginView;
    WelcomePage welcomeView;
    WorkoutPage workoutView;

    public ApplicationController() {

        setupDatabase();

        this.mainFrame = new MainFrame();

        welcomeView = new WelcomePage();
        new WelcomeController(dbManager, this, welcomeView);

        loginView = new LoginPage();
        new LoginController(dbManager, this, loginView);

        registerView = new RegisterPage();
        new RegisterController(dbManager, this, registerView);

        homeView = new HomePage();
        new HomeController(dbManager, this, homeView);

        workoutView = new WorkoutPage();
        new WorkoutController(dbManager, this, workoutView);

        mainFrame.addPanel(welcomeView, MainFrame.WELCOME_PAGE);
        mainFrame.addPanel(loginView, MainFrame.LOGIN_PAGE);
        mainFrame.addPanel(homeView, MainFrame.HOME_PAGE);
        mainFrame.addPanel(registerView, MainFrame.REGISTER_PAGE);
        mainFrame.addPanel(workoutView, MainFrame.NEW_WORKOUT_PAGE);

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
            System.out.println("Database connection failed. " + e.getMessage());
            System.exit(0);
        }
    }

    public void showLoginPage() {
        mainFrame.showPanel(MainFrame.LOGIN_PAGE);
    }

    public void showHomePage(User user) {
        if (user != null) {
            currentUser = user;
        }
        homeView.setWelcomeMessage(currentUser);
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

        WorkoutPageInterface view = workoutView;

        view.reset();
        workoutView.addExercisesList(dbManager.getDefaultExercises());
        workoutView.addSetList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        mainFrame.showPanel(MainFrame.NEW_WORKOUT_PAGE);
    }

    public void logout() {

        RegisterPageInterface regView = registerView;
        LoginPageInterface logView = loginView;

        currentUser = null;
        regView.reset();
        logView.reset();
        mainFrame.showPanel(MainFrame.WELCOME_PAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ApplicationController());
    }

    public User getCurrentUser() {
        return currentUser;
    }

}