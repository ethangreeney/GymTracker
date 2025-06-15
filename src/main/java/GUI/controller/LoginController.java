package GUI.controller;

import GUI.model.DatabaseManager;
import GUI.model.User;
import GUI.view.LoginPageInterface;

public class LoginController {
    DatabaseManager model;
    LoginPageInterface view;
    ApplicationController controller;

    public LoginController(DatabaseManager model, ApplicationController controller, LoginPageInterface view) {
        this.model = model;
        this.view = view;
        this.controller = controller;

        view.addLoginListener(e -> {
            String user = view.getUsername();
            String pass = view.getPassword();
            User currentUser = model.getUser(user, pass);

            if (currentUser == null) {
                view.invalidLogin();
            } else {
                controller.showHomePage(currentUser);
            }
        });

    }

}
