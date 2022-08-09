package mainbase.factory;

import mainbase.browserenum.BrowserEnum;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverFactory {

    public static WebDriver createDriver(BrowserEnum browser) {
        switch (browser) {
            case CHROME:
                return new ChromeFactory().createDriver();
            case EDGE:
                return new  EdgeFactory().createDriver();
            case FIREFOX:
                return new FirefoxFactory().createDriver();
            case EDGE_HEADLESS:
                return new EdgeHeadlessFactory().createDriver();
            case FIREFOX_HEADLESS:
                return new FirefoxHeadlessFactory().createDriver();
            case CHROME_HEADLESS:
                return new ChromeHeadlessFactory().createDriver();
        }
        throw new UnsupportedOperationException("Browser type is not supported!");
    }

    public static WebDriver createRemoteWebDriver(BrowserEnum browser, String url) throws MalformedURLException {
        switch (browser) {
            case EDGE:
                return new EdgeFactory().createRemoteDriver(browser, url);
            case FIREFOX:
                return new FirefoxFactory().createRemoteDriver(browser, url);
            case EDGE_HEADLESS:
                return new EdgeHeadlessFactory().createRemoteDriver(browser, url);
            case FIREFOX_HEADLESS:
                return new FirefoxHeadlessFactory().createRemoteDriver(browser, url);
            case CHROME_HEADLESS:
                return new ChromeHeadlessFactory().createRemoteDriver(browser, url);
        }
        throw new UnsupportedOperationException("Browser type is not supported!");
    }
}
