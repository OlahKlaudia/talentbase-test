package pages.registrationpage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitLoadingPage extends WebelementsPage {
    public WaitLoadingPage(WebDriver driver) {
        super(driver);
    }


    @Override
    protected void load() {

    }
    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(signInLink));
    }
    @Step("Wait element visibility.")
    public void waitButtonVisibility() {
        wait.until(ExpectedConditions.visibilityOf(signInLink));
    }
}
