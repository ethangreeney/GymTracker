import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class PageManager {

    public static HashMap<Class<? extends Page>, Page> pageInstanceMap = new HashMap<>();

    public static void navigate(Class<? extends Page> pageType) {

        Page targetPage = pageInstanceMap.computeIfAbsent(pageType, newKey -> {
            try {
                return newKey.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                System.out.println("Error occured when creating new instance of page");
                return null;
            }
        });

        targetPage.display();

    }

}
