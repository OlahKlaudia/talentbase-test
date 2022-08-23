package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollToBottom extends TalentbasePage {
    public ScrollToBottom(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".footer")
    private WebElement footer;

    @Override
    protected void load() {

    }
    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(footer));
    }
    @Step("Scroll down to footer.")
    public void waitFooterVisibility() {
        wait.until(ExpectedConditions.visibilityOf(footer)).click();
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
    }
}
