import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Scanner;

public class PageManagerTest {

    private final InputStream originalIn = System.in;

    // Create test versions of pages that don't try to read input
    private static class TestWelcome implements Page {
        private boolean displayCalled = false;

        @Override
        public void display() {
            displayCalled = true;
            // Don't call handleInput()
        }

        @Override
        public void handleInput() {
            // Empty implementation
        }
    }

    private static class TestLogin implements Page {
        private boolean displayCalled = false;

        @Override
        public void display() {
            displayCalled = true;
            // Don't call handleInput()
        }

        @Override
        public void handleInput() {
            // Empty implementation
        }
    }

    private static class TestRegister implements Page {
        private boolean displayCalled = false;

        @Override
        public void display() {
            displayCalled = true;
            // Don't call handleInput()
        }

        @Override
        public void handleInput() {
            // Empty implementation
        }
    }

    @BeforeEach
    public void setUp() throws Exception {
        // Reset the page instance map
        Field pageInstanceMapField = PageManager.class.getDeclaredField("pageInstanceMap");
        pageInstanceMapField.setAccessible(true);
        pageInstanceMapField.set(null, new HashMap<Class<? extends Page>, Page>());

        // Add our test implementations to the page map
        @SuppressWarnings("unchecked")
        HashMap<Class<? extends Page>, Page> pageInstanceMap = (HashMap<Class<? extends Page>, Page>) pageInstanceMapField
                .get(null);

        pageInstanceMap.put(Welcome.class, new TestWelcome());
        pageInstanceMap.put(Login.class, new TestLogin());
        pageInstanceMap.put(Register.class, new TestRegister());
    }

    @AfterEach
    public void tearDown() {
        // Restore System.in
        System.setIn(originalIn);
    }

    @Test
    public void testNavigateToWelcomePage() throws Exception {
        // Navigate to Welcome page
        PageManager.navigate(Welcome.class);

        // Get the page instance map
        Field pageInstanceMapField = PageManager.class.getDeclaredField("pageInstanceMap");
        pageInstanceMapField.setAccessible(true);
        @SuppressWarnings("unchecked")
        HashMap<Class<? extends Page>, Page> pageInstanceMap = (HashMap<Class<? extends Page>, Page>) pageInstanceMapField
                .get(null);

        // Verify Welcome page was added to the map
        assertTrue(pageInstanceMap.containsKey(Welcome.class));
        assertNotNull(pageInstanceMap.get(Welcome.class));
        assertTrue(pageInstanceMap.get(Welcome.class) instanceof Page);

        // Verify display was called
        TestWelcome welcomePage = (TestWelcome) pageInstanceMap.get(Welcome.class);
        assertTrue(welcomePage.displayCalled);
    }

    @Test
    public void testNavigateToLoginPage() throws Exception {
        // Navigate to Login page
        PageManager.navigate(Login.class);

        // Get the page instance map
        Field pageInstanceMapField = PageManager.class.getDeclaredField("pageInstanceMap");
        pageInstanceMapField.setAccessible(true);
        @SuppressWarnings("unchecked")
        HashMap<Class<? extends Page>, Page> pageInstanceMap = (HashMap<Class<? extends Page>, Page>) pageInstanceMapField
                .get(null);

        // Verify Login page was added to the map
        assertTrue(pageInstanceMap.containsKey(Login.class));
        assertNotNull(pageInstanceMap.get(Login.class));
        assertTrue(pageInstanceMap.get(Login.class) instanceof Page);

        // Verify display was called
        TestLogin loginPage = (TestLogin) pageInstanceMap.get(Login.class);
        assertTrue(loginPage.displayCalled);
    }

    @Test
    public void testNavigateToMultiplePages() throws Exception {
        // Navigate to multiple pages
        PageManager.navigate(Welcome.class);
        PageManager.navigate(Login.class);
        PageManager.navigate(Register.class);

        // Get the page instance map
        Field pageInstanceMapField = PageManager.class.getDeclaredField("pageInstanceMap");
        pageInstanceMapField.setAccessible(true);
        @SuppressWarnings("unchecked")
        HashMap<Class<? extends Page>, Page> pageInstanceMap = (HashMap<Class<? extends Page>, Page>) pageInstanceMapField
                .get(null);

        // Verify all pages were added to the map
        assertEquals(3, pageInstanceMap.size());
        assertTrue(pageInstanceMap.containsKey(Welcome.class));
        assertTrue(pageInstanceMap.containsKey(Login.class));
        assertTrue(pageInstanceMap.containsKey(Register.class));
    }

    @Test
    public void testReuseExistingPageInstance() throws Exception {
        // Navigate to Welcome page twice
        PageManager.navigate(Welcome.class);

        // Get the reference to the current page
        Field pageInstanceMapField = PageManager.class.getDeclaredField("pageInstanceMap");
        pageInstanceMapField.setAccessible(true);
        @SuppressWarnings("unchecked")
        HashMap<Class<? extends Page>, Page> pageInstanceMap = (HashMap<Class<? extends Page>, Page>) pageInstanceMapField
                .get(null);
        Page firstInstance = pageInstanceMap.get(Welcome.class);

        // Navigate again
        PageManager.navigate(Welcome.class);

        // Get the new reference
        Page secondInstance = pageInstanceMap.get(Welcome.class);

        // Verify it's the same instance
        assertSame(firstInstance, secondInstance);

        // We should still have 3 pages in the map (one for each test page added in
        // setUp)
        assertEquals(3, pageInstanceMap.size());
    }

    // Test using custom MockPage class
    public static class MockPage implements Page {
        private boolean displayCalled = false;

        @Override
        public void display() {
            displayCalled = true;
        }

        @Override
        public void handleInput() {
            // Not needed for this test
        }

        public boolean wasDisplayCalled() {
            return displayCalled;
        }
    }

    @Test
    public void testPageDisplayMethodCalled() throws Exception {
        // Set up a mock page instance
        MockPage mockPage = new MockPage();

        // Add the mock page to the page instance map
        Field pageInstanceMapField = PageManager.class.getDeclaredField("pageInstanceMap");
        pageInstanceMapField.setAccessible(true);
        @SuppressWarnings("unchecked")
        HashMap<Class<? extends Page>, Page> pageInstanceMap = (HashMap<Class<? extends Page>, Page>) pageInstanceMapField
                .get(null);
        pageInstanceMap.put(MockPage.class, mockPage);

        // Navigate to the mock page
        PageManager.navigate(MockPage.class);

        // Verify the display method was called
        assertTrue(mockPage.wasDisplayCalled());
    }
}