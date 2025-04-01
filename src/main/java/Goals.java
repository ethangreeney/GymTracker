import java.util.Calendar;
import java.util.Date;

public class Goals {

    String goalDescription;
    Date startDate;
    Date endDate;
    Date timeToComplete;

    Goals(String description) {
        goalDescription = description;
        startDate = new Date();
    }

    public void completeGoal() {
        endDate = new Date();
    }

    public String toString() {

        StringBuilder goalString = new StringBuilder();

        if (endDate == null) {
            goalString.append("Goal description: \n" + goalDescription);
            goalString.append("Start date: " + startDate);
            goalString.append("End date: not yet completed");
        } else {
            goalString.append("Goal description: \n" + goalDescription);
            goalString.append("Start date: " + startDate);
            goalString.append("End date: " + endDate);
        }

        return goalString.toString();
    }
}
