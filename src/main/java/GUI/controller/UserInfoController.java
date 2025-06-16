package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.UserInfoPageInterface;

public class UserInfoController {

    public UserInfoController(DatabaseManager model, ApplicationController controller, UserInfoPageInterface view) {

        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));
    }

}
