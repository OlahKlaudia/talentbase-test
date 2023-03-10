package mainbase.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainbase.mainenum.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeFactory extends GenericFactory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        return maximize(new EdgeDriver());
    }

    @Override
    public WebDriver createRemoteDriver(BrowserEnum browser, String url) {
        EdgeOptions edgeOptions = new EdgeOptions();
        try {
            return new RemoteWebDriver(new URL("http://" + url + "/wd/hub"), edgeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
