package GUI.controller;

import java.util.List;

import GUI.model.DatabaseManager;
import GUI.model.Goal;
import GUI.model.User;
import GUI.view.LoginPageInterface;

public class LoginController {

    public LoginController(DatabaseManager model, ApplicationController controller, LoginPageInterface view) {
        view.addLoginListener(e -> {
            String user = view.getUsername();
            String pass = view.getPassword();
            User currentUser = model.getUser(user, pass);

            if (currentUser == null) {
                view.invalidLogin();
            } else {
                List<Goal> goals = model.getGoals(currentUser);
                currentUser.setUserGoals(goals);
                controller.showHomePage(currentUser);
            }
        });

    }
}
