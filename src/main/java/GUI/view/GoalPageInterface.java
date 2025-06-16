package GUI.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionListener;

import GUI.model.Goal;

public interface GoalPageInterface {

    void addBackListener(ActionListener e);

    void addNewGoalListener(ActionListener e);

    void addCompleteGoalListener(ActionListener e);

    void addGoalSelectionListener(ListSelectionListener e);

    String getNewGoalDescription();

    Goal getSelectedGoal();

    void populateGoals(List<Goal> goals);

    void updateGoalDetails(String details);

    void clearInput();

    void showMessage(String message, boolean isError);

}