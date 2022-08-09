package mainbase.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainbase.browserenum.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeFactory extends GenericFactory{

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return maximize(new ChromeDriver());
    }

    @Override
    public WebDriver createRemoteDriver(BrowserEnum browser, String url) throws MalformedURLException {
        WebDriver driver;
        driver = maximize(new RemoteWebDriver(new URL(url), new ChromeOptions()));
        return driver;
    }
}
