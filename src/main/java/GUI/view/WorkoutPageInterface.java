package GUI.view;

import java.awt.event.ActionListener;
import java.util.List;

public interface WorkoutPageInterface {

    String getWorkoutName();

    void addFirstNextListener(ActionListener e);

    void userExercises(List<String> StringList);

    void addSecondNextListener(ActionListener e);

    void reset();

    void addBackListener(ActionListener e);

    void addExercisesList(List<String> exerciseList);

}