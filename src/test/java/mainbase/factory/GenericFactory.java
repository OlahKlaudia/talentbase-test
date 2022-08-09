package mainbase.factory;

import mainbase.interfaces.BrowserInterface;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

abstract class GenericFactory implements BrowserInterface {

    public WebDriver maximize(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return driver;
    }
}
