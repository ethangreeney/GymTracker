package GUI.model;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    // Exercise object class, has get methods and set methods

    private final String name;
    private final List<SetInfo> sets;

    public Exercise(String exerciseName) {
        this.name = exerciseName;
        sets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<SetInfo> getSets() {
        return sets;
    }

    public void addSet(int w, int r) {
        this.getSets().add(new SetInfo(w, r));
    }

    @Override
    public String toString() {

        String returnInformation = getName();

        int count = 1;

        for (SetInfo set : sets) {
            returnInformation += "\n   Set " + count++ + ": [Weight: " + set.getWeight() + " KG] [Reps: "
                    + set.getReps() + "]";
        }

        return returnInformation;

    }

}
