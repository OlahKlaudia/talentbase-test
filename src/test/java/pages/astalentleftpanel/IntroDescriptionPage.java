package pages.astalentleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IntroDescriptionPage extends AsTalentBasePage {
    public static final String SHORT_SUMMARY = "test";
    @FindBy(css = "textarea[name='summary']")
    public WebElement summaryTextarea;
    @FindBy(css = ".MuiFormHelperText-root")
    public WebElement errorMessage;
    public static final String INTRO_DESCRIPTION = "/intro";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(INTRO_DESCRIPTION);
    }

    public IntroDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify to get error message when type short summary text.")
    public void shortSummary() {
        logger.info("Fill the form with short summary.");
        summaryTextarea.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        summaryTextarea.sendKeys(SHORT_SUMMARY);
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();

    }

    @Step("Get error message color.")
    public String getColor() {
        logger.info("Get error message color.");
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getCssValue("color");
    }
}
