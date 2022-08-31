package mainbase.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainbase.mainenum.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;

public class ChromeFactory extends GenericFactory{
    private static final String SCREENSHOT_FOLDER = "." + File.separator + "target" + File.separator +"download" + File.separator ;
    HashMap<String,Object> chromePrefs= new HashMap<>();
    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
//"\\target\\download\\"
        chromePrefs.put("download.default_directory", SCREENSHOT_FOLDER);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        return maximize(new ChromeDriver());
    }

    @Override
    public WebDriver createRemoteDriver(BrowserEnum browser, String url) throws MalformedURLException {
        WebDriver driver;
        driver = maximize(new RemoteWebDriver(new URL(url), new ChromeOptions()));
        return driver;
    }
}
