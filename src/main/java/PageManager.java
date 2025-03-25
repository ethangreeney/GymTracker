public class PageManager {

    private static PageManager singleton;

    public PageManager getInstance() {
        return singleton == null ? singleton = new PageManager() : singleton;
    }

}
