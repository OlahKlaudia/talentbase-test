package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitFooterElement extends TalentbaseLandingPage {
    @FindBy(css = "footer a[href='/partners'] p")
    private WebElement waitPartnersLink;
    public WaitFooterElement(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {
    }
    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(waitPartnersLink));
    }
    @Step("Scroll down to footer.")
    public void scrollDown() {
        logger.info("Scroll down to footer.");
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
    }
}
