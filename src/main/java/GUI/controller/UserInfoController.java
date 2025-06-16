package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.UserInfoPageInferface;

public class UserInfoController {

    public UserInfoController(DatabaseManager model, ApplicationController controller, UserInfoPageInferface view) {

        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));
        view.addEditListener(e -> view.toEditPanel());
    }

}
