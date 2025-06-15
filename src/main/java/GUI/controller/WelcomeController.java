package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.WelcomePageInterface;

public class WelcomeController {

    DatabaseManager model;
    WelcomePageInterface view;
    ApplicationController controller;

    public WelcomeController(DatabaseManager model, ApplicationController controller, WelcomePageInterface view) {
        this.model = model;
        this.view = view;
        this.controller = controller;

        view.addLoginListener(e -> controller.showLoginPage());
        view.addRegisterListener(e -> controller.showRegisterPage());
    }

}
