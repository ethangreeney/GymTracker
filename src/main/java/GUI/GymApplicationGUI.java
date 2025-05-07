package GUI;

import java.awt.Color;

import javax.swing.JFrame;

public class GymApplicationGUI {

    private static JFrame frame = new JFrame("GymTracking Application");

    public static void main(String[] args) {
        GymApplicationGUI manager = new GymApplicationGUI();
        manager.FrameManager();

    }

    private void FrameManager() {

        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(25, 25, 25));
        frame.setVisible(true);
    }
}
