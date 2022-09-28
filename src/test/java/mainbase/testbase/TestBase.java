package mainbase.testbase;

import mainbase.mainenum.BrowserEnum;
import mainbase.extension.ScreenshotExtension;
import mainbase.factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;


@ExtendWith(ScreenshotExtension.class)
public class TestBase {
    public static String browser = System.getProperty("browser");
    public static String driverType = System.getProperty("remote");
    public static String ipAddress = System.getProperty("ip");
    private static final String DEFAULT_IP_ADDRESS = "192.168.0.146:4444";
//    private static final String DEFAULT_IP_ADDRESS = "http://192.168.0.146:4444/wd/hub";
    private static final BrowserEnum DEFAULT_BROWSER = BrowserEnum.CHROME;

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static final Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeEach
    public void beforeTest() throws MalformedURLException {
        driver.set(getDriverType(driverType));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Create 'Web Driver' for '{}' browser",getDriver());
    }
    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void removeDriver() {
        driver.remove();
    }
    public static BrowserEnum getBrowserEnum(String browser) {
        for (BrowserEnum browsersEnum : BrowserEnum.values()) {
            if (browsersEnum.browserName.equalsIgnoreCase(browser)) {
                return browsersEnum;
            }
        }
        return DEFAULT_BROWSER;
    }
    private static WebDriver getDriverType(String driverString) {
        if(Objects.equals(driverString, "true")) {
            if(ipAddress==null) {
                ipAddress = DEFAULT_IP_ADDRESS;
            }
            return DriverFactory.createRemoteWebDriver(getBrowserEnum(browser),ipAddress);
        } else{
            return DriverFactory.createDriver(getBrowserEnum(browser));
        }
    }
    @AfterEach
    public void afterTest() {
//        getDriver().close();
    }
}
