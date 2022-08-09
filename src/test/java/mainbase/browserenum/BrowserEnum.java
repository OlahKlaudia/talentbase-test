package mainbase.browserenum;

public enum BrowserEnum {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    CHROME_HEADLESS("chromeheadless"),
    EDGE_HEADLESS("edgeheadless"),
    FIREFOX_HEADLESS("firefoxheadless");
    public final String browserName;

    BrowserEnum(String browserName) {
        this.browserName=browserName;
    }

    public String toString() {
        return browserName;
    }
}
