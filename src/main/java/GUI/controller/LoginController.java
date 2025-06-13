package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.model.User;
import GUI.view.LoginPage;

public class LoginController {
    DatabaseManager db;
    LoginPage loginPage;
    ApplicationController appController;

    public LoginController(DatabaseManager model, ApplicationController controller, LoginPage view) {
        db = model;
        loginPage = view;
        appController = controller;

        loginPage.addLoginListener(e -> {
            String user = loginPage.getUsername();
            String pass = loginPage.getPassword();
            User currentUser = db.getUser(user, pass);

            if (currentUser == null) {
                System.out.println("Invalid username or password");
            }

            appController.showHomePage(currentUser);
        });

    }

}
