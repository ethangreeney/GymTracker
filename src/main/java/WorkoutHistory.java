public class WorkoutHistory implements Page {

    @Override
    public void display() {
        System.out.println("======= Workout History =======\n");

        for (Workout workout : UserManager.currentUser.getWorkoutHistory()) {
            System.out.println(workout.toString());
        }
    }

    @Override
    public void handleInput() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleInput'");
    }

}
