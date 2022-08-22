package pages.linkspages;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnersAndInvestorsPage extends TalentbasePage {
    @FindBy(css = "a[href='/partners']")
    private WebElement partnersAndInvestorsMenuItem;
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
    @Step("Navigate to Partners and Investors Page, and scroll down to bottom.")
    public void navigatePartnersAndInvestors() {
        partnersAndInvestorsMenuItem.click();
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
    }
}
