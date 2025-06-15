package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.model.User;
import GUI.view.RegisterPageInterface;

public class RegisterController {

    private User currentUser;

    public RegisterController(DatabaseManager model, ApplicationController controller, RegisterPageInterface view) {

        currentUser = new User();

        view.addRegisterListener(e -> {

            currentUser.setUsername(view.getUsername());
            currentUser.setPassword(view.getPassword());

            if (model.userExists(currentUser.getUsername())) {
                view.duplicateUsername();
            } else {
                view.validDetail();
            }

        });

        view.addConfirmListener(e -> {

            currentUser.setName(view.getInfoName());
            try {
                currentUser.setAge(Integer.parseInt(view.getInfoAge()));
            } catch (NumberFormatException exception) {
                view.invalidUserInfo("Age");
                return;
            }
            try {
                currentUser.setHeight(Integer.parseInt(view.getInfoHeight()));
            } catch (NumberFormatException exception) {
                view.invalidUserInfo("Height");
                return;
            }
            try {
                currentUser.setWeight((Integer.parseInt(view.getInfoWeight())));

            } catch (NumberFormatException exception) {
                view.invalidUserInfo("Weight");
                return;
            }

            boolean savedToDatabase = model.addUser(currentUser);

            if (savedToDatabase) {
                controller.showHomePage(currentUser);
            } else {
                view.failedToSaveData();
            }

        });

    }

}
