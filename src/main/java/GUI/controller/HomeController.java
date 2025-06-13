package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.HomePage;

public class HomeController {
    DatabaseManager model;
    HomePage view;
    ApplicationController controller;

    public HomeController(DatabaseManager model, ApplicationController controller, HomePage view) {
        this.model = model;
        this.view = view;
        this.controller = controller;

    }
}
