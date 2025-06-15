package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.WelcomePageInterface;

public class WelcomeController {

    public WelcomeController(DatabaseManager model, ApplicationController controller, WelcomePageInterface view) {
        view.addLoginListener(e -> controller.showLoginPage());
        view.addRegisterListener(e -> controller.showRegisterPage());
    }

}
