package GUI.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Goal {

    // Goal object class, has get methods and set methods
    private final String goalDescription;
    private Date startDate;
    private Date endDate;
    private int goalId;

    public static SimpleDateFormat getDateFormat() {
        return DATE_FORMAT;
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

    public Goal(String description) {
        goalDescription = description;
        startDate = new Date();
    }

    public void completeGoal() {
        endDate = new Date();
    }

    public void reopenGoal() {
        endDate = null;
    }

    @Override
    public String toString() {
        if (endDate != null) {
            return "Complete: " + goalDescription;
        }
        return goalDescription;
    }

    public String getFullDetails() {
        StringBuilder goalString = new StringBuilder();
        goalString.append("Goal: \n").append(goalDescription);
        goalString.append("\n\nStart Date: ").append(DATE_FORMAT.format(startDate));

        if (endDate == null) {
            goalString.append("\nStatus: In Progress");
        } else {
            goalString.append("\nCompleted On: ").append(DATE_FORMAT.format(endDate));
        }
        return goalString.toString();
    }

    public String getGoalDescription() {
        return this.goalDescription;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public void setStartDate(java.sql.Date date) {
        this.startDate = date;
    }
}
