package mainbase.interfaces;

import mainbase.browserenum.BrowserEnum;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface BrowserInterface {
    WebDriver createDriver();
    WebDriver createRemoteDriver(BrowserEnum browser, String url) throws MalformedURLException;
}
