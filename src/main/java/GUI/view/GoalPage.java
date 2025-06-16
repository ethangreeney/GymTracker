package GUI.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

import GUI.model.Goal;

public class GoalPage extends JPanel implements GoalPageInterface {

    private final String asciiArt = """

              ██████╗  ██████╗  █████╗ ██╗     ███████╗
             ██╔════╝ ██╔═══██╗██╔══██╗██║     ██╔════╝
             ██║  ███╗██║   ██║███████║██║     ███████╗
             ██║   ██║██║   ██║██╔══██║██║     ╚════██║
             ╚██████╔╝╚██████╔╝██║  ██║███████╗███████║
              ╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚══════╝╚══════╝
            """;

    private final JLabel goalArtLabel;
    private final JLabel messageLabel;
    private final JButton backButton;
    private final JButton addGoalButton;
    private final JButton completeGoalButton;

    private final JList<Goal> goalList;
    private final DefaultListModel<Goal> listModel;
    private final JTextArea goalDetailsArea;
    private final JTextArea newGoalInput;

    private final JPanel topBar;
    private final JPanel contentPanel;
    private final JPanel inputPanel;

    public GoalPage() {
        // setting background and layout
        setBackground(Utilities.backgroundColour);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // creating top bar for back button
        topBar = new JPanel();
        topBar.setBackground(getBackground());
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.X_AXIS));
        backButton = new JButton("Back");
        topBar.add(Box.createHorizontalGlue());
        topBar.add(backButton);
        topBar.add(Box.createHorizontalStrut(20));
        topBar.setMaximumSize(Utilities.topBarGap(topBar));
        add(topBar);

        // ascii art
        goalArtLabel = new JLabel(Utilities.toHtmlFormat(asciiArt));
        goalArtLabel.setAlignmentX(CENTER_ALIGNMENT);
        goalArtLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(goalArtLabel);

        messageLabel = new JLabel(" ");
        messageLabel.setAlignmentX(CENTER_ALIGNMENT);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageLabel);

        // content panel which the user interacts with
        contentPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        contentPanel.setBackground(getBackground());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        listModel = new DefaultListModel<>();
        goalList = new JList<>(listModel);
        goalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(goalList);
        contentPanel.add(listScrollPane);

        goalDetailsArea = new JTextArea("Select a goal to see details.");
        goalDetailsArea.setEditable(false);
        goalDetailsArea.setLineWrap(true);
        goalDetailsArea.setWrapStyleWord(true);
        JScrollPane detailsScrollPane = new JScrollPane(goalDetailsArea);
        contentPanel.add(detailsScrollPane);
        add(contentPanel);

        // input panel for when creating a new goal
        inputPanel = new JPanel();
        inputPanel.setBackground(getBackground());
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));

        inputPanel.add(new JLabel("New Goal Description:"));
        newGoalInput = new JTextArea(3, 20);
        newGoalInput.setLineWrap(true);
        newGoalInput.setWrapStyleWord(true);
        JScrollPane inputScrollPane = new JScrollPane(newGoalInput);
        inputPanel.add(inputScrollPane);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(getBackground());
        addGoalButton = new JButton("Add New Goal");
        completeGoalButton = new JButton("Complete Selected Goal");
        buttonPanel.add(addGoalButton);
        buttonPanel.add(completeGoalButton);
        inputPanel.add(buttonPanel);

        add(inputPanel);
    }

    @Override
    public void addBackListener(ActionListener e) {
        backButton.addActionListener(e);
    }

    @Override
    public void addNewGoalListener(ActionListener e) {
        addGoalButton.addActionListener(e);
    }

    @Override
    public void addCompleteGoalListener(ActionListener e) {
        completeGoalButton.addActionListener(e);
    }

    @Override
    public void addGoalSelectionListener(ListSelectionListener e) {
        goalList.addListSelectionListener(e);
    }

    @Override
    public String getNewGoalDescription() {
        return newGoalInput.getText();
    }

    @Override
    public Goal getSelectedGoal() {
        return goalList.getSelectedValue();
    }

    @Override
    public void populateGoals(List<Goal> goals) {
        listModel.clear();
        if (goals != null) {
            for (Goal goal : goals) {
                listModel.addElement(goal);
            }
        }
    }

    @Override
    public void updateGoalDetails(String details) {
        goalDetailsArea.setText(details);
    }

    @Override
    public void clearInput() {
        newGoalInput.setText("");
        goalList.clearSelection();
        goalDetailsArea.setText("Select a goal to see details.");
        showMessage(" ", false);
    }

    @Override
    public void showMessage(String message, boolean isError) {
        messageLabel.setText(message);
        messageLabel.setForeground(isError ? Color.RED : Color.BLACK);
    }
}