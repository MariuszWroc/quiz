package pl.myproject.quiz.util.constant;

/**
 *
 * @author Mariusz Czarny
 */
public enum ApplicationStrings {
    DEFAULT_PATH("C:\\Users\\xe050991049\\Documents\\NetBeansProjects\\EYGame\\src\\resources\\"),
    DEFAULT_PATH_LINUX("/home/mariusz/"),
    CATALOG_QUESTION("quiz_pool"),
    CATALOG_SETTING("applicationsetting"),
    CATALOG_RANKING("ranking"),
    DEFAULT_THEME("south-street");

    private final String name;

    private ApplicationStrings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
