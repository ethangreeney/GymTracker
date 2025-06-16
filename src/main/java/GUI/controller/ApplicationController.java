package GUI.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingUtilities;

import GUI.model.DatabaseManager;
import GUI.model.Goal;
import GUI.model.User;
import GUI.view.GoalPage;
import GUI.view.GoalPageInterface;
import GUI.view.HomePage;
import GUI.view.LoginPage;
import GUI.view.LoginPageInterface;
import GUI.view.MainFrame;
import GUI.view.RegisterPage;
import GUI.view.RegisterPageInterface;
import GUI.view.UserInfoPage;
import GUI.view.UserInfoPageInterface;
import GUI.view.WelcomePage;
import GUI.view.WorkoutHistoryPage;
import GUI.view.WorkoutHistoryPageInterface;
import GUI.view.WorkoutPage;
import GUI.view.WorkoutPageInterface;

public class ApplicationController {

    private final MainFrame mainFrame;
    private DatabaseManager dbManager;
    private User currentUser;

    // Store the view objects a class member for later use in other methods

    HomePage homeView;
    RegisterPage registerView;
    LoginPage loginView;
    WelcomePage welcomeView;
    WorkoutPage workoutView;
    WorkoutHistoryPage workoutHistoryView;
    UserInfoPage userInfoView;
    GoalPage goalView;

    WorkoutController workoutController;

    public ApplicationController() {

        setupDatabase();

        this.mainFrame = new MainFrame();

        // Create scenes. Scenes are a model, view, and controller group

        workoutView = new WorkoutPage();
        workoutController = new WorkoutController(dbManager, this, workoutView);

        welcomeView = new WelcomePage();
        new WelcomeController(dbManager, this, welcomeView);

        loginView = new LoginPage();
        new LoginController(dbManager, this, loginView);

        registerView = new RegisterPage();
        new RegisterController(dbManager, this, registerView);

        homeView = new HomePage();
        new HomeController(dbManager, this, homeView);

        workoutHistoryView = new WorkoutHistoryPage();
        new WorkoutHistoryController(dbManager, this, workoutHistoryView);

        userInfoView = new UserInfoPage();
        new UserInfoController(dbManager, this, userInfoView);

        goalView = new GoalPage();
        new GoalController(dbManager, this, goalView);

        // Add all of the views to the main JFrame

        mainFrame.addPanel(welcomeView, MainFrame.WELCOME_PAGE);
        mainFrame.addPanel(loginView, MainFrame.LOGIN_PAGE);
        mainFrame.addPanel(homeView, MainFrame.HOME_PAGE);
        mainFrame.addPanel(registerView, MainFrame.REGISTER_PAGE);
        mainFrame.addPanel(workoutView, MainFrame.NEW_WORKOUT_PAGE);
        mainFrame.addPanel(workoutHistoryView, MainFrame.WORKOUT_HISTORY_PAGE);
        mainFrame.addPanel(userInfoView, MainFrame.USER_INFO_PAGE);
        mainFrame.addPanel(goalView, MainFrame.GOAL_PAGE);

        mainFrame.showPanel(MainFrame.WELCOME_PAGE);
        mainFrame.setVisible(true);

    }

    private void setupDatabase() {
        // establish connection with database
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

    public void showWelcomePage() {
        loginView.reset();
        registerView.reset();
        mainFrame.showPanel(MainFrame.WELCOME_PAGE);
    }

    public void showHomePage(User user) {
        currentUser = user;
        homeView.setWelcomeMessage(currentUser);
        mainFrame.showPanel(MainFrame.HOME_PAGE);
    }

    public void showRegisterPage() {
        mainFrame.showPanel(MainFrame.REGISTER_PAGE);
    }

    public void showGoalPage() {

        // assign the views in thier interface to limit their public APIs

        GoalPageInterface view = goalView;

        List<Goal> goals = dbManager.getGoals(currentUser);
        currentUser.setUserGoals(goals);

        view.clearInput();
        view.populateGoals(currentUser.getUserGoals());
        mainFrame.showPanel(MainFrame.GOAL_PAGE);
    }

    public void showUserInfoPage() {

        UserInfoPageInterface view = userInfoView;

        view.updateUserInfo(currentUser);
        view.toDisplayPanel();

        mainFrame.showPanel(MainFrame.USER_INFO_PAGE);
    }

    public void showWorkoutHistoryPage() {

        WorkoutHistoryPageInterface view = workoutHistoryView;

        view.populateWorkouts(dbManager.getWorkoutHistory(currentUser));
        mainFrame.showPanel(MainFrame.WORKOUT_HISTORY_PAGE);
    }

    public void showNewWorkoutPage() {

        WorkoutPageInterface view = workoutView;

        workoutController.reset();
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