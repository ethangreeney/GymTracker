import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    }

    public static void saveUsers() {

    }

    public static void login() {

    }

    public static void register() {

    }

}
