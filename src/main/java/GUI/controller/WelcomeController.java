package GUI.controller;

import GUI.model.DatabaseManager;

public class WelcomeController {

    DatabaseManager db;
    WelcomePage welcomePage;
    ApplicationControler appController;
    

    public WelcomeController(DatabaseManager model, ApplicationController controller, WelcomePage view) {
        db = model;
        welcomePage = view;
        appController = controller;
    }

    WelcomePage.addLoginListener(()->appControler.showLoginPage);
    WelcomePage.addLoginListener(()->appControler.showLoginPage);
    WelcomePage.addLoginListener(()->appControler.showLoginPage);

}
