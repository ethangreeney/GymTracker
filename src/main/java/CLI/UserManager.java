package CLI;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UserManager {

    public static User currentUser;
    private static final Map<String, User> users = new HashMap<>();

    private static final String FILE_PATH = "resources/userInfo.json";

    public static void loadUsers() {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("No user info database found... Creating new file");
            saveUsers();
            return;
        }

        try (FileReader reader = new FileReader(FILE_PATH)) {

            var userListType = new TypeToken<ArrayList<User>>() {
            }.getType();

            ArrayList<User> userList = new Gson().fromJson(reader, userListType);

            for (User user : userList) {
                users.put(user.getUsername(), user);
            }

        } catch (Exception e) {
            System.out.println("Error Reading File");
        }

    }

    public static Map<String, User> getUsers() {
        return users;
    }

    public static void saveUsers() {
        if (currentUser != null) {
            if (users.containsKey(currentUser.getUsername())) {
                users.replace(currentUser.getUsername(), currentUser);
            } else {
                users.put(currentUser.getUsername(), currentUser);
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Collection<User> userList = users.values();

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(userList, writer);
        } catch (Exception e) {
            System.out.println("File Writing Failed");
        }

    }

    public static boolean login(String username, String Password) {

        if (users.containsKey(username) && users.get(username).getPassword().equals(Password)) {

            currentUser = users.get(username);

            return true;

        }

        return false;

    }

    public static void register() {

        users.put(currentUser.getUsername(), currentUser);

    }

}
