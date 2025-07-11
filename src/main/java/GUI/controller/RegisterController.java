package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.model.User;
import GUI.view.RegisterPageInterface;

public class RegisterController {

    private User currentUser;

    public RegisterController(DatabaseManager model, ApplicationController controller, RegisterPageInterface view) {

        currentUser = new User();

        // add action listeners to the buttons of the view

        view.addRegisterListener(e -> {

            currentUser.setUsername(view.getUsername());
            currentUser.setPassword(view.getPassword());

            if (currentUser.getUsername().equals("") || currentUser.getPassword().equals("")) {
                view.emptyInfo();
                return;
            }

            if (model.userExists(currentUser.getUsername())) {
                view.duplicateUsername();
            } else {
                view.validDetail();
            }

        });

        view.addBackListener(e -> controller.showWelcomePage());

        view.addConfirmListener(e -> {

            String name = view.getInfoName();

            if (name.trim().equals("")) {
                view.invalidUserInfo("Name");
                return;
            } else {
                currentUser.setName(view.getInfoName());
            }

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
