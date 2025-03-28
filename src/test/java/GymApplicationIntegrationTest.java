import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Scanner;

public class GymApplicationIntegrationTest {

    @TempDir
    static File tempDir;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    public void setUp() throws Exception {
        // Redirect System.out
        System.setOut(new PrintStream(outContent));

        // Set a temporary file path for testing
        Field filePathField = UserManager.class.getDeclaredField("filePath");
        filePathField.setAccessible(true);
        File tempFile = new File(tempDir, "testUserInfo.json");
        filePathField.set(null, tempFile.getAbsolutePath());

        // Reset the users map
        Field usersField = UserManager.class.getDeclaredField("users");
        usersField.setAccessible(true);
        usersField.set(null, new java.util.HashMap<String, User>());

        // Reset current user
        UserManager.currentUser = null;

        // Reset the page instance map
        Field pageInstanceMapField = PageManager.class.getDeclaredField("pageInstanceMap");
        pageInstanceMapField.setAccessible(true);
        pageInstanceMapField.set(null, new java.util.HashMap<Class<? extends Page>, Page>());
    }

    @AfterEach
    public void tearDown() {
        // Restore System.out and System.in
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testStringToIntValidInput() {
        // For this test, we don't need to read from System.in
        String input = "123";
        int result = GymApplication.stringToInt(input);
        assertEquals(123, result);
    }

    @Test
    public void testStringToIntInvalidThenValidInput() {
        // Prepare input: first invalid, then valid
        String simulatedInput = "abc\n123\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Save original scanner
        Scanner originalScanner = GymApplication.scan;

        try {
            // Set new scanner with our input stream
            GymApplication.scan = new Scanner(System.in);

            // Call the method
            int result = GymApplication.stringToInt("abc");

            // Verify the result
            assertEquals(123, result);

            // Verify error message was printed
            assertTrue(outContent.toString().contains("Not a valid integer input"));
        } finally {
            // Restore original scanner
            GymApplication.scan = originalScanner;
        }
    }

    // We need to create simplified page classes for testing that don't actually try
    // to read input
    private static class TestRegister implements Page {
        @Override
        public void display() {
            // Don't call handleInput()
        }

        @Override
        public void handleInput() {
            // Just create and populate a test user
            User user = new User();
            user.setUsername("newuser");
            user.setPassword("password123");
            user.setName("New User");
            user.setAge(25);
            user.setHeight(175);
            user.setWeight(70);

            UserManager.currentUser = user;
            UserManager.register();
        }
    }

    private static class TestLogin implements Page {
        @Override
        public void display() {
            // Don't call handleInput()
        }

        @Override
        public void handleInput() {
            // Simulate login
            UserManager.login("newuser", "password123");
        }
    }

    @Test
    public void testRegisterAndLoginFlow() throws Exception {
        // Replace the page implementations with our test versions
        Field pageInstanceMapField = PageManager.class.getDeclaredField("pageInstanceMap");
        pageInstanceMapField.setAccessible(true);
        @SuppressWarnings("unchecked")
        java.util.HashMap<Class<? extends Page>, Page> pageInstanceMap = (java.util.HashMap<Class<? extends Page>, Page>) pageInstanceMapField
                .get(null);

        pageInstanceMap.put(Register.class, new TestRegister());
        pageInstanceMap.put(Login.class, new TestLogin());

        try {
            // Start with registration page
            UserManager.loadUsers();

            // Get the TestRegister page and manually call handleInput
            TestRegister registerPage = (TestRegister) pageInstanceMap.get(Register.class);
            registerPage.handleInput();

            // Verify registration succeeded
            assertNotNull(UserManager.currentUser);
            assertEquals("newuser", UserManager.currentUser.getUsername());

            // Simulate logout
            UserManager.currentUser = null;

            // Get the TestLogin page and manually call handleInput
            TestLogin loginPage = (TestLogin) pageInstanceMap.get(Login.class);
            loginPage.handleInput();

            // Verify login succeeded
            assertNotNull(UserManager.currentUser);
            assertEquals("newuser", UserManager.currentUser.getUsername());
            assertEquals("New User", UserManager.currentUser.getName());
            assertEquals(25, UserManager.currentUser.getAge());
            assertEquals(175, UserManager.currentUser.getHeight());
            assertEquals(70, UserManager.currentUser.getWeight());
        } catch (Exception e) {
            fail("Test failed with exception: " + e.getMessage());
        }
    }
}