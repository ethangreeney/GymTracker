import java.util.HashMap;

public class PageManager {

    public static HashMap<Class<? extends Page>, Page> pageInstanceMap = new HashMap<>();

    public static void navigate(Class<? extends Page> pageType) {

        System.out.println();

        Page targetPage = pageInstanceMap.computeIfAbsent(pageType, newKey -> {
            try {
                return newKey.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                System.out.println("Error occured when creating new instance of page");
                PageManager.navigate(Shutdown.class);
            }
            return null;
        });

        targetPage.display();

    }

}
