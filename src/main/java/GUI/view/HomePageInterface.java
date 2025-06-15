package GUI.view;

import java.awt.event.ActionListener;

import GUI.model.User;

public interface HomePageInterface {

    void setWelcomeMessage(User user);

    void addWorkoutListener(ActionListener e);

    void addWorkoutHistoryListener(ActionListener e);

    void addUserInfoListener(ActionListener e);

    void addGoalListener(ActionListener e);

}