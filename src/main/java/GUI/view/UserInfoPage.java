package GUI.view;

import javax.swing.*;

import GUI.model.User;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

public class UserInfoPage extends JPanel implements UserInfoPageInferface {
    private String asciiArt = """

            ██╗   ██╗███████╗███████╗██████╗     ██╗███╗   ██╗███████╗ ██████╗
            ██║   ██║██╔════╝██╔════╝██╔══██╗    ██║████╗  ██║██╔════╝██╔═══██╗
            ██║   ██║███████╗█████╗  ██████╔╝    ██║██╔██╗ ██║█████╗  ██║   ██║
            ██║   ██║╚════██║██╔══╝  ██╔══██╗    ██║██║╚██╗██║██╔══╝  ██║   ██║
            ╚██████╔╝███████║███████╗██║  ██║    ██║██║ ╚████║██║     ╚██████╔╝
             ╚═════╝ ╚══════╝╚══════╝╚═╝  ╚═╝    ╚═╝╚═╝  ╚═══╝╚═╝      ╚═════╝
            """;

    private JLabel userInformation;
    private JLabel warningText;
    private JPanel topBar;
    private JButton back;
    private JButton edit;
    private JButton confirm;

    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JLabel BMILabel;

    private JPanel displayPanel;

    private JLabel nameLabelEdit;
    private JLabel ageLabelEdit;
    private JLabel heightLabelEdit;
    private JLabel weightLabelEdit;

    private JTextField name;
    private JTextField age;
    private JTextField height;
    private JTextField weight;

    private JPanel editPanel;

    private Dimension labelSize = new Dimension(210, 30);
    private final Dimension textFieldSize = new Dimension(215, 35);

    public UserInfoPage() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Utilities.backgroundColour);

        add(Box.createRigidArea(Utilities.buttonGap));

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

        warningText = new JLabel(" ");
        warningText.setAlignmentX(CENTER_ALIGNMENT);
        warningText.setForeground(Color.red);
        add(warningText);

        displayPanel = new JPanel();
        displayPanel.setBackground(this.getBackground());
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        nameLabel = new JLabel("test name");
        nameLabel.setAlignmentX(CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 30));

        ageLabel = new JLabel("test age");
        ageLabel.setAlignmentX(CENTER_ALIGNMENT);
        ageLabel.setFont(new Font("Arial", Font.BOLD, 30));

        heightLabel = new JLabel("test height");
        heightLabel.setAlignmentX(CENTER_ALIGNMENT);
        heightLabel.setFont(new Font("Arial", Font.BOLD, 30));

        weightLabel = new JLabel("test weight");
        weightLabel.setAlignmentX(CENTER_ALIGNMENT);
        weightLabel.setFont(new Font("Arial", Font.BOLD, 30));

        BMILabel = new JLabel("test BMI");
        BMILabel.setAlignmentX(CENTER_ALIGNMENT);
        BMILabel.setFont(new Font("Arial", Font.BOLD, 30));

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

        heightLabelEdit = new JLabel("Height: ");
        heightLabelEdit.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(heightLabelEdit);

        height = new JTextField();
        height.setPreferredSize(textFieldSize);
        height.setMaximumSize(textFieldSize);
        height.setMinimumSize(textFieldSize);
        height.setAlignmentX(CENTER_ALIGNMENT);
        editPanel.add(height);

        weightLabelEdit = new JLabel("Weight: ");
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
        nameLabel.setText(user.getName());
        ageLabel.setText(String.valueOf(user.getAge()));
        heightLabel.setText(String.valueOf(user.getHeight()));
        weightLabel.setText(String.valueOf(user.getWeight()));
    }

    public void updateBMI(Double bmi) {
        BMILabel.setText(String.valueOf(bmi));
    }

    @Override
    public void invalidUpdateInfo(String s) {
        warningText.setText("Invalid " + s);
        warningText.setVisible(true);
    }

}
