package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.model.User;
import GUI.view.UserInfoPageInterface;

public class UserInfoController {

    public UserInfoController(DatabaseManager model, ApplicationController controller, UserInfoPageInterface view) {

        view.addBackListener(e -> controller.showHomePage(controller.getCurrentUser()));
        view.addEditListener(e -> view.toEditPanel());
        view.addConfirmListener(e -> {

            // use String.trim() to ensure that fields are not just spaces, and remove
            // leading / trailing whitespace

            User currentUser = controller.getCurrentUser();

            String newName = view.getNewName().trim();
            String newWeight = view.getNewWeight().trim();
            String newHeight = view.getNewHeight().trim();
            String newAge = view.getNewAge().trim();

            if (newName.isEmpty() || newWeight.isEmpty() || newHeight.isEmpty() || newAge.isEmpty()) {
                view.invalidUpdateInfo("Fields cannot be empty");
                return;
            }

            // set the user name, then check that all integer values can successfully be
            // parsed as an int

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
