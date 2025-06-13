package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.LoginPage;

public class LoginController {
    DatabaseManager db;
    LoginPage loginPage;
    ApplicationController appController;

    public LoginController(DatabaseManager model, ApplicationController controller, LoginPage view) {
        db = model;
        loginPage = view;
        appController = controller;

    }

}
