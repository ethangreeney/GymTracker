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

            String newName = view.getNewName().trim();
            String newWeight = view.getNewWeight().trim();
            String newHeight = view.getNewHeight().trim();
            String newAge = view.getNewAge().trim();

            if (newName.isEmpty() || newWeight.isEmpty() || newHeight.isEmpty() || newAge.isEmpty()) {
                view.invalidUpdateInfo("Fields cannot be empty");
                return;
            }

            currentUser.setName(newName);

            try {
                currentUser.setWeight(Integer.parseInt(newWeight));
                currentUser.setHeight(Integer.parseInt(newHeight));
                currentUser.setAge(Integer.parseInt(newAge));
            } catch (NumberFormatException exception) {
                view.invalidUpdateInfo("Age, Height, and Weight must be valid numbers");
                return;
            }

            model.updateUser(currentUser);
            view.updateUserInfo(currentUser);
            view.toDisplayPanel();
        });
    }

}
