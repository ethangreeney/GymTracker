public class UserInfo implements Page {

    @Override
    public void display() {

        System.out.println("Name: " + UserManager.currentUser.getName());
        System.out.println("Age: " + UserManager.currentUser.getAge());
        System.out.println("Height (CM): " + UserManager.currentUser.getHeight());
        System.out.println("Weight (KG): " + UserManager.currentUser.getWeight());
        System.out.println();

        System.out.println("Enter any input to return");
        

        handleInput();
    


        
    }

    @Override
    public void handleInput() {

        GymApplication.scan.nextLine();

        PageManager.navigate(Home.class);
        
    }

}
