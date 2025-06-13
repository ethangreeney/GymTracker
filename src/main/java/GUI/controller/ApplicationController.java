package GUI.controller;

import javax.swing.SwingUtilities;

import GUI.model.DatabaseManager;
import GUI.view.MainFrame;

public class ApplicationController {
    private MainFrame mainFrame;
    private DatabaseManager dbManager;

    public ApplicationController() {

        this.mainFrame = new MainFrame();

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ApplicationController());
    }

}
