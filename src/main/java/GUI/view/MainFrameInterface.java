package GUI.view;

import javax.swing.JPanel;

public interface MainFrameInterface {

    String WELCOME_PAGE = "WelcomePanel";
    String LOGIN_PAGE = "LoginPanel";
    String HOME_PAGE = "HomePanel";
    String REGISTER_PAGE = "RegisterPanel";
    int FRAME_WIDTH = 600;
    int FRAME_HEIGHT = 500;

    void showPanel(String panelName);

    void addPanel(JPanel toAdd, String panelName);

    void setVisible(boolean bool);

}