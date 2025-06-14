package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.WelcomePage;

public class WelcomeController {

    DatabaseManager model;
    WelcomePage view;
    ApplicationController controller;

    public WelcomeController(DatabaseManager model, ApplicationController controller, WelcomePage view) {
        this.model = model;
        this.view = view;
        this.controller = controller;

        view.addLoginListener(e -> controller.showLoginPage());
        view.addRegisterListener(e -> controller.showRegisterPage());
    }

}
