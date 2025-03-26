import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserManager {

    public static User currentUser;
    private static Map<String, User> users = new HashMap<>();
    private static String filePath = "userInfo.json";

    public static void loadUsers() {

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No user info database found... Creating new file");
            saveUsers();
            return;
        }

        try (FileReader reader = new FileReader(filePath)) {

            var userListType = new TypeToken<ArrayList<User>>() {
            }.getType();

            ArrayList<User> userList = new Gson().fromJson(reader, userListType);

            for (User user : userList) {
                users.put(user.getName(), user);
            }

        } catch (Exception e) {
            System.out.println("Error Reading File");
        }
    }

    public static void saveUsers() {

    }

    public static void login() {

    }

    public static void register() {

    }

}
