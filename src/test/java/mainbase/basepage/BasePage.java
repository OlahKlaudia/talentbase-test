package mainbase.basepage;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import mainbase.testbase.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage extends LoadableComponent<BasePage> {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker fake;
    protected Actions action;

    protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action = new Actions(driver);
        fake = new Faker();
        PageFactory.initElements(driver, this);
        this.get();
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }

}
