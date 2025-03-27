import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private String name;
    private List <setInfo> sets;

    public Exercise(String n){
        this.name = n;
    }

  
    public String getName() {
        return name;
    }
   
    public List<setInfo> getSets() {
        if(this.sets == null){
            sets = new ArrayList<>();
        } 
        return sets;
    }

    public void addSet(int w, int r){
        this.getSets().add(new setInfo(w, r));
    }

    @Override
    public String toString() {

        String returnInformation = getName();

        int count = 1;

        for(setInfo set: sets){
            returnInformation += "\n   Set " + count++ + ": [Weight: " + set.getWeight() + " kg] [Reps: " + set.getReps() + "]";
        }

        return returnInformation;
       
    }

}
