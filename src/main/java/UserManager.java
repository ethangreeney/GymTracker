import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {

            JSONArray userArray = (JSONArray) parser.parse(reader);

            for (var userFromArray : userArray) {

                JSONObject userFromFile = (JSONObject) userFromArray;

                User user = new User();

                user.setUsername((String) userFromFile.get("username"));
                user.setPassword((String) userFromFile.get("password"));

                user.setAge((int) userFromFile.get("age"));
                user.setHeight((int) userFromFile.get("height"));
                user.setName((String) userFromFile.get("name"));
                user.setWeight((int) userFromFile.get("weight"));

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
