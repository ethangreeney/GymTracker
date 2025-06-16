package GUI.controller;

import java.util.List;

import javax.swing.event.ListSelectionEvent;

import GUI.model.DatabaseManager;
import GUI.model.Goal;
import GUI.model.User;
import GUI.view.GoalPageInterface;

public class GoalController {

    private final DatabaseManager model;
    private final ApplicationController controller;
    private final GoalPageInterface view;

    public GoalController(DatabaseManager model, ApplicationController controller, GoalPageInterface view) {
        this.model = model;
        this.controller = controller;
        this.view = view;

        // add action listeners on the view buttons

        this.view.addBackListener(e -> this.controller.showHomePage(this.controller.getCurrentUser()));
        this.view.addNewGoalListener(e -> addNewGoal());
        this.view.addCompleteGoalListener(e -> completeSelectedGoal());
        this.view.addGoalSelectionListener(this::handleGoalSelection);
    }

    private void addNewGoal() {
        User currentUser = controller.getCurrentUser();
        String description = view.getNewGoalDescription().trim();

        if (description.isEmpty()) {
            view.showMessage("Goal description cannot be empty.", true);
            return;
        }

        Goal newGoal = new Goal(description);
        boolean success = model.saveGoal(currentUser, newGoal);

        if (success) {
            view.showMessage("Goal added successfully!", false);
            refreshGoals();
            view.clearInput();
        } else {
            view.showMessage("Failed to save the new goal.", true);
        }
    }

    private void completeSelectedGoal() {
        Goal selectedGoal = view.getSelectedGoal();

        if (selectedGoal == null) {
            view.showMessage("Please select a goal to complete.", true);
            return;
        }

        if (selectedGoal.getEndDate() != null) {
            view.showMessage("This goal is already complete.", false);
            return;
        }

        selectedGoal.completeGoal();
        boolean success = model.updateGoal(selectedGoal);

        if (success) {
            view.showMessage("Goal marked as complete!", false);
            view.updateGoalDetails(selectedGoal.toString());
            view.populateGoals(model.getGoals(controller.getCurrentUser()));
        } else {
            view.showMessage("Failed to update the goal.", true);
            selectedGoal.reopenGoal();
        }
    }

    private void handleGoalSelection(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Goal selectedGoal = view.getSelectedGoal();
            if (selectedGoal != null) {
                view.updateGoalDetails(selectedGoal.getFullDetails());
            } else {
                view.updateGoalDetails("Select a goal to see details.");
            }
        }
    }

    private void refreshGoals() {
        User currentUser = controller.getCurrentUser();
        List<Goal> goals = model.getGoals(currentUser);
        currentUser.setUserGoals(goals);
        view.populateGoals(goals);
    }
}