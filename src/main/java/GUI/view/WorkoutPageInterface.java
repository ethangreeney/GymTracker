package GUI.view;

import java.awt.event.ActionListener;
import java.util.List;

public interface WorkoutPageInterface {

    String getWorkoutName();

    void next1Listener(ActionListener e);

    void addBackListener(ActionListener e);

    void userExercises(List<String> StringList);

    void reset();

}