package GUI.controller;

import GUI.model.DatabaseManager;

public class WelcomeController {

    DatabaseManager db;
    WelcomePage welcomePage;
    ApplicationControler appController;
    

    public WelcomeController(DatabaseManager db) {
        this.db = db;
    }

    WelcomePage.addLoginListener(()->appControler.showLoginPage);
    WelcomePage.addLoginListener(()->appControler.showLoginPage);
    WelcomePage.addLoginListener(()->appControler.showLoginPage);

}
