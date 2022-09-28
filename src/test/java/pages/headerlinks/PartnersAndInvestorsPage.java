package pages.headerlinks;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.InputElementsPage;

public class PartnersAndInvestorsPage extends InputElementsPage {
    @FindBy(css = "a[href='/partners']")
    private WebElement partnersAndInvestorsMenuItem;
    @FindBy(css = ".MuiGrid-item:nth-child(1) button")
    private WebElement contactUsButton;
    @FindBy(css = ".MuiGrid-item:nth-child(3) button[type=\"button\"]")
    private WebElement becomeAPartnerButton;
    @FindBy(css = ".MuiGrid-item:nth-child(7) button[type=\"button\"]")
    private WebElement becomeAnInvestorButton;
    private static final String PARTNER_INVESTORS = "/partners";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(PARTNER_INVESTORS);
    }

    public PartnersAndInvestorsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click contact us button.")
    public void clickContactUsButton() {
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        wait.until(ExpectedConditions.elementToBeClickable(contactUsButton)).click();

    }
    @Step("Click contact us button.")
    public void clickBecomeAPartnerButton() {
        action.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(becomeAPartnerButton)).click();
    }
    @Step("Click contact us button.")
    public void clickBecomeAnInvestorButton() {
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        wait.until(ExpectedConditions.elementToBeClickable(becomeAnInvestorButton)).click();
    }
}
