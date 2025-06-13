package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.HomePage;

public class HomeController {
    DatabaseManager db;
    HomePage homePage;
    ApplicationController appController;

    public HomeController(DatabaseManager model, ApplicationController controller, HomePage view) {
        db = model;
        homePage = view;
        appController = controller;

    }
}
