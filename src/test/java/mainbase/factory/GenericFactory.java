package mainbase.factory;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

abstract class GenericFactory implements BrowserInterface {

    public WebDriver maximize(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
    public WebDriver fullHDMaximize(WebDriver driver) {
        Dimension d = new Dimension(1920,1080);
        driver.manage().window().setSize(d);
        return driver;
    }
}
