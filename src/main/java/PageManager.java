import java.util.HashMap;

public class PageManager {

    public static HashMap<Class<? extends Page>, Page> pageInstanceMap = new HashMap<>();

    public void display(Class<? extends Page> pageType) {
        var targetPage = pageInstanceMap.computeIfAbsent(pageType, newKey -> {
            return newKey.getDeclaredConstructor().newInstance();
        });

    }

}
