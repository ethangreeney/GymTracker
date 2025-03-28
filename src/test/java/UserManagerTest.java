import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class UserManagerTest {
    
    @TempDir
    static File tempDir;
    
    private User testUser;
    private String originalFilePath;
    
    @BeforeEach
    public void setUp() throws Exception {
        // Save the original file path
        Field filePathField = UserManager.class.getDeclaredField("filePath");
        filePathField.setAccessible(true);
        originalFilePath = (String) filePathField.get(null);
        
        // Set a temporary file path for testing
        File tempFile = new File(tempDir, "testUserInfo.json");
        filePathField.set(null, tempFile.getAbsolutePath());
        
        // Reset the users map
        Field usersField = UserManager.class.getDeclaredField("users");
        usersField.setAccessible(true);
        usersField.set(null, new HashMap<String, User>());
        
        // Reset current user
        UserManager.currentUser = null;
        
        // Create a test user
        testUser = new User();
        testUser.setUsername("testuser");
        testUser.setPassword("password123");
        testUser.setName("Test User");
        testUser.setAge(25);
        testUser.setHeight(175);
        testUser.setWeight(70);
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        // Restore the original file path
        Field filePathField = UserManager.class.getDeclaredField("filePath");
        filePathField.setAccessible(true);
        filePathField.set(null, originalFilePath);
        
        // Reset current user
        UserManager.currentUser = null;
    }
    
    @Test
    public void testRegisterAndSaveUser() throws Exception {
        // Set the current user
        UserManager.currentUser = testUser;
        
        // Register the user
        UserManager.register();
        
        // Get the users map
        Field usersField = UserManager.class.getDeclaredField("users");
        usersField.setAccessible(true);
        @SuppressWarnings("unchecked")
        Map<String, User> users = (Map<String, User>) usersField.get(null);
        
        // Verify the user was added to the map
        assertTrue(users.containsKey("testuser"));
        assertEquals(testUser, users.get("testuser"));
        
        // Save the users
        UserManager.saveUsers();
        
        // Get the file path
        Field filePathField = UserManager.class.getDeclaredField("filePath");
        filePathField.setAccessible(true);
        String filePath = (String) filePathField.get(null);
        
        // Verify the file was created
        File userFile = new File(filePath);
        assertTrue(userFile.exists());
    }
    
    @Test
    public void testLoginSuccess() throws Exception {
        // Set up a user in the users map
        Field usersField = UserManager.class.getDeclaredField("users");
        usersField.setAccessible(true);
        @SuppressWarnings("unchecked")
        Map<String, User> users = (Map<String, User>) usersField.get(null);
        users.put("testuser", testUser);
        
        // Attempt to login
        boolean result = UserManager.login("testuser", "password123");
        
        // Verify login was successful
        assertTrue(result);
        assertEquals(testUser, UserManager.currentUser);
    }
    
    @Test
    public void testLoginFailure() throws Exception {
        // Set up a user in the users map
        Field usersField = UserManager.class.getDeclaredField("users");
        usersField.setAccessible(true);
        @SuppressWarnings("unchecked")
        Map<String, User> users = (Map<String, User>) usersField.get(null);
        users.put("testuser", testUser);
        
        // Attempt to login with incorrect password
        boolean result = UserManager.login("testuser", "wrongpassword");
        
        // Verify login failed
        assertFalse(result);
        assertNull(UserManager.currentUser);
        
        // Attempt to login with non-existent username
        result = UserManager.login("nonexistentuser", "password123");
        
        // Verify login failed
        assertFalse(result);
        assertNull(UserManager.currentUser);
    }
    
    @Test
    public void testSaveAndLoadUsers() throws Exception {
        // Set up a user in the users map
        Field usersField = UserManager.class.getDeclaredField("users");
        usersField.setAccessible(true);
        @SuppressWarnings("unchecked")
        Map<String, User> users = (Map<String, User>) usersField.get(null);
        users.put("testuser", testUser);
        
        // Save the users
        UserManager.saveUsers();
        
        // Clear the users map
        users.clear();
        
        // Load the users
        UserManager.loadUsers();
        
        // Verify the user was loaded
        assertTrue(users.containsKey("testuser"));
        assertEquals("testuser", users.get("testuser").getUsername());
        assertEquals("password123", users.get("testuser").getPassword());
    }
}
