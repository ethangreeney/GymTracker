package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.model.User;
import GUI.view.RegisterPage;

public class RegisterController {

    private DatabaseManager model;
    private RegisterPage view;
    private ApplicationController controller;

    private User currentUser;

    public RegisterController(DatabaseManager model, ApplicationController controller, RegisterPage view) {
        this.model = model;
        this.view = view;
        this.controller = controller;

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

    }

}
