package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.WelcomePage;

public class WelcomeController {

    DatabaseManager db;
    WelcomePage welcomePage;
    ApplicationController appController;

    public WelcomeController(DatabaseManager model, ApplicationController controller, WelcomePage view) {
        db = model;
        welcomePage = view;
        appController = controller;

        welcomePage.addLoginListener(() -> appControler.showLoginPage);
        welcomePage.addLoginListener(() -> appControler.showLoginPage);
        welcomePage.addLoginListener(() -> appControler.showLoginPage);
    }

}
