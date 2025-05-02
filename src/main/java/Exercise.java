import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private String name;
    private List<SdetInfo> sets;

    public Exercise(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public List<SdetInfo> getSets() {
        if (this.sets == null) {
            sets = new ArrayList<SdetInfo>();
        }
        return sets;
    }

    public void addSet(int w, int r) {
        this.getSets().add(new SdetInfo(w, r));
    }

    @Override
    public String toString() {

        String returnInformation = getName();

        int count = 1;

        for (SdetInfo set : sets) {
            returnInformation += "\n   Set " + count++ + ": [Weight: " + set.getWeight() + " KG] [Reps: "
                    + set.getReps() + "]";
        }

        return returnInformation;

    }

}
