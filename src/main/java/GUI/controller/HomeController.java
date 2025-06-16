package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.HomePageInterface;

public class HomeController {

    public HomeController(DatabaseManager model, ApplicationController controller, HomePageInterface view) {

        // add action listeners to the buttons of the view

        view.addGoalListener(e -> controller.showGoalPage());
        view.addUserInfoListener(e -> controller.showUserInfoPage());
        view.addWorkoutHistoryListener(e -> controller.showWorkoutHistoryPage());
        view.addNewWorkoutListener(e -> controller.showNewWorkoutPage());
        view.addLogoutListener(e -> controller.logout());

    }
}
