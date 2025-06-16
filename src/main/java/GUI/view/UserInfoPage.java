package GUI.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import GUI.model.User;

public class UserInfoPage extends JPanel implements UserInfoPageInterface {
    private final String asciiArt = """

            ██╗   ██╗███████╗███████╗██████╗     ██╗███╗   ██╗███████╗ ██████╗
            ██║   ██║██╔════╝██╔════╝██╔══██╗    ██║████╗  ██║██╔════╝██╔═══██╗
            ██║   ██║███████╗█████╗  ██████╔╝    ██║██╔██╗ ██║█████╗  ██║   ██║
            ██║   ██║╚════██║██╔══╝  ██╔══██╗    ██║██║╚██╗██║██╔══╝  ██║   ██║
            ╚██████╔╝███████║███████╗██║  ██║    ██║██║ ╚████║██║     ╚██████╔╝
             ╚═════╝ ╚══════╝╚══════╝╚═╝  ╚═╝    ╚═╝╚═╝  ╚═══╝╚═╝      ╚═════╝
            """;

    private final JLabel userInformation;
    private final JLabel warningText;
    private final JPanel topBar;
    private final JButton back;
    private final JButton edit;
    private final JButton confirm;

    private final JLabel nameLabel;
    private final JLabel ageLabel;
    private final JLabel heightLabel;
    private final JLabel weightLabel;
    private final JLabel BMILabel;

    private final JPanel displayPanel;

    private final JLabel nameLabelEdit;
    private final JLabel ageLabelEdit;
    private final JLabel heightLabelEdit;
    private final JLabel weightLabelEdit;

    private final JTextField name;
    private final JTextField age;
    private final JTextField height;
    private final JTextField weight;

    private final JPanel editPanel;

    private final Dimension textFieldSize = new Dimension(215, 35);

    public UserInfoPage() {
        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Utilities.backgroundColour);

        add(Box.createRigidArea(Utilities.buttonGap));

        // top bar for back button
        topBar = new JPanel();
        topBar.setBackground(this.getBackground());
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.X_AXIS));

        back = new JButton("Back");
        topBar.add(Box.createHorizontalGlue());
        topBar.add(back);
        topBar.add(Box.createHorizontalStrut(20));
        topBar.setMaximumSize(Utilities.topBarGap(topBar));

        add(topBar);

        userInformation = new JLabel(Utilities.toHtmlFormat(asciiArt));
        userInformation.setHorizontalAlignment(SwingConstants.CENTER);
        userInformation.setAlignmentX(CENTER_ALIGNMENT);

        add(userInformation);

        // warning text
        warningText = new JLabel(" ");
        warningText.setAlignmentX(CENTER_ALIGNMENT);
        warningText.setForeground(Color.red);
        add(warningText);

        // display user information
        displayPanel = new JPanel();
        displayPanel.setBackground(this.getBackground());
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        nameLabel = new JLabel("test name");
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 22));

        ageLabel = new JLabel("test age");
        ageLabel.setAlignmentX(CENTER_ALIGNMENT);
        ageLabel.setFont(new Font("Arial", Font.BOLD, 22));

        heightLabel = new JLabel("test height");
        heightLabel.setAlignmentX(CENTER_ALIGNMENT);
        heightLabel.setFont(new Font("Arial", Font.BOLD, 22));

        weightLabel = new JLabel("test weight");
        weightLabel.setAlignmentX(CENTER_ALIGNMENT);
        weightLabel.setFont(new Font("Arial", Font.BOLD, 22));

        BMILabel = new JLabel("test BMI");
        BMILabel.setAlignmentX(CENTER_ALIGNMENT);
        BMILabel.setFont(new Font("Arial", Font.BOLD, 22));

        edit = new JButton("Edit Information");
        edit.setAlignmentX(CENTER_ALIGNMENT);

        displayPanel.add(nameLabel);
        displayPanel.add(ageLabel);
        displayPanel.add(heightLabel);
        displayPanel.add(weightLabel);
        displayPanel.add(BMILabel);

        displayPanel.add(Box.createRigidArea(Utilities.buttonGap));

        displayPanel.add(edit);

        add(displayPanel);

        displayPanel.setVisible(true);

        editPanel = new JPanel();
        editPanel.setBackground(this.getBackground());
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.Y_AXIS));

        nameLabelEdit = new JLabel("Name: ");
        nameLabelEdit.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(nameLabelEdit);

        name = new JTextField();
        name.setPreferredSize(textFieldSize);
        name.setMaximumSize(textFieldSize);
        name.setMinimumSize(textFieldSize);
        name.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(name);

        ageLabelEdit = new JLabel("Age: ");
        ageLabelEdit.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(ageLabelEdit);

        age = new JTextField();
        age.setPreferredSize(textFieldSize);
        age.setMaximumSize(textFieldSize);
        age.setMinimumSize(textFieldSize);
        age.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(age);

        heightLabelEdit = new JLabel("Height (CM): ");
        heightLabelEdit.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(heightLabelEdit);

        height = new JTextField();
        height.setPreferredSize(textFieldSize);
        height.setMaximumSize(textFieldSize);
        height.setMinimumSize(textFieldSize);
        height.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(height);

        weightLabelEdit = new JLabel("Weight (KG): ");
        weightLabelEdit.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(weightLabelEdit);

        weight = new JTextField();
        weight.setPreferredSize(textFieldSize);
        weight.setMaximumSize(textFieldSize);
        weight.setMinimumSize(textFieldSize);
        weight.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(weight);

        editPanel.add(Box.createRigidArea(Utilities.buttonGap));

        confirm = new JButton("Confirm Changes");
        confirm.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(confirm);
        editPanel.setVisible(false);
        add(editPanel);

    }

    @Override
    public void addBackListener(ActionListener e) {
        back.addActionListener(e);

    }

    @Override
    public void addEditListener(ActionListener e) {
        edit.addActionListener(e);
    }

    @Override
    public void addConfirmListener(ActionListener e) {
        confirm.addActionListener(e);
    }

    @Override
    public String getNewName() {
        return name.getText();
    }

    @Override
    public String getNewAge() {
        return age.getText();
    }

    @Override
    public String getNewHeight() {
        return height.getText();
    }

    @Override
    public String getNewWeight() {
        return weight.getText();
    }

    @Override
    public void toDisplayPanel() {
        warningText.setText(" ");
        editPanel.setVisible(false);
        name.setText("");
        age.setText("");
        height.setText("");
        weight.setText("");
        displayPanel.setVisible(true);
    }

    @Override
    public void toEditPanel() {
        warningText.setText(" ");
        displayPanel.setVisible(false);
        name.setText("");
        age.setText("");
        height.setText("");
        weight.setText("");
        editPanel.setVisible(true);
    }

    @Override
    public void updateUserInfo(User user) {
        nameLabel.setText("Name: " + user.getName());
        ageLabel.setText("Age: " + String.valueOf(user.getAge()));
        heightLabel.setText("Height: " + String.valueOf(user.getHeight()) + " CM");
        weightLabel.setText("Weight: " + String.valueOf(user.getWeight()) + " KG");
        BMILabel.setText("BMI: " + String.valueOf(Math.round(user.getBMI() * 10) / 10f));
    }

    @Override
    public void invalidUpdateInfo(String s) {
        warningText.setText("Invalid " + s);
        warningText.setVisible(true);
    }

}
