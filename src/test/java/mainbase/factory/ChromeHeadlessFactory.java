package mainbase.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainbase.mainenum.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeHeadlessFactory extends GenericFactory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        return maximize(new ChromeDriver(chromeOptions.setHeadless(true)));
    }

    @Override
    public WebDriver createRemoteDriver(BrowserEnum browser, String url) throws MalformedURLException {
        WebDriver driver;
        driver = maximize(new RemoteWebDriver(new URL(url), new ChromeOptions().setHeadless(true)));
        return driver;
    }
}
