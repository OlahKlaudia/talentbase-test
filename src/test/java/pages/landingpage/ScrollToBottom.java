package pages.landingpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollToBottom extends TalentbasePage {
    @FindBy(css = ".footer")
    private WebElement footer;
    @FindBy(css = "footer a[href='/termsOfService']")
    private WebElement websiteTermsFooterLink;
    public ScrollToBottom(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {

    }
    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(websiteTermsFooterLink));
        wait.until(ExpectedConditions.visibilityOfAllElements(footer));

    }
    public void waitFooterVisibility() {
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
    }
}
