package GUI.view;

import java.awt.event.ActionListener;

public interface LoginPageInterface {

    void addLoginListener(ActionListener e);

    String getUsername();

    String getPassword();

    void invalidLogin();

    void reset();

    void addBackListener(ActionListener e);

}