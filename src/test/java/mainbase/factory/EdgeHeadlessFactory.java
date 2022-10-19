package mainbase.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainbase.mainenum.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeHeadlessFactory extends GenericFactory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("--no-sandbox");
        edgeOptions.addArguments("--disable-dev-shm-usage");
        return fullHDMaximize(new EdgeDriver(edgeOptions.setHeadless(true)));
    }

    @Override
    public WebDriver createRemoteDriver(BrowserEnum browser, String url) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless", "--window-size=1920,1200");
        edgeOptions.addArguments("--no-sandbox");
        edgeOptions.addArguments("--disable-dev-shm-usage");
        try {
            return new RemoteWebDriver(new URL("http://" + url + "/wd/hub"), edgeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
