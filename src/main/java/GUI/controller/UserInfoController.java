package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.model.User;
import GUI.view.UserInfoPageInferface;

public class UserInfoController {

    public UserInfoController(DatabaseManager model, ApplicationController controller, UserInfoPageInferface view) {

        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));
        view.addEditListener(e -> view.toEditPanel());
        view.addConfirmListener(e -> {

            User currentUser = controller.getCurrentUser();

            currentUser.setName(view.getNewName());

            try {
                currentUser.setWeight(Integer.parseInt(view.getNewWeight()));
                currentUser.setHeight(Integer.parseInt(view.getNewHeight()));
                currentUser.setAge(Integer.parseInt(view.getNewAge()));
            } catch (NumberFormatException exception) {
                view.invalidUpdateInfo("Name, Age, or Height");
                return;
            }

            model.updateUser(currentUser);
            view.updateUserInfo(currentUser);
            view.toDisplayPanel();
        });
    }

}
