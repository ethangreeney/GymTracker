package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.view.UserInfoPageInferface;

public class UserInfoController {

    public UserInfoController(DatabaseManager model, ApplicationController controller, UserInfoPageInferface view) {

        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));
        view.addEditListener(e -> view.toEditPanel());
        view.addConfirmListener(e -> {

            try {
                controller.getCurrentUser().setName(view.getNewName());
                controller.getCurrentUser().setWeight(Integer.parseInt(view.getNewWeight()));
                controller.getCurrentUser().setHeight(Integer.parseInt(view.getNewWeight()));
                controller.getCurrentUser().setAge(Integer.parseInt(view.getNewWeight()));
            } catch (NumberFormatException exception) {

            }

            controller.showUserInfoPage();

        });
    }

}
