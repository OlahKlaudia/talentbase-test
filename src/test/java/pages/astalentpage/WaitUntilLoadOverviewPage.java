package pages.astalentpage;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentLeftPanelBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUntilLoadOverviewPage extends AsTalentLeftPanelBasePage {

    public WaitUntilLoadOverviewPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(projectsLink));
    }
    @Step("Wait until scroll down.")
    public void waitUntilScrollDown(){
        action.sendKeys(Keys.PAGE_DOWN).perform();
    }

}
