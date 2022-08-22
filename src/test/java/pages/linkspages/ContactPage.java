package pages.linkspages;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends TalentbasePage {
    @FindBy(css = "a[href='/contact']")
    private WebElement contactMenuItem;
    private static final String CONTACT_PAGE = "/contact";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(CONTACT_PAGE);
    }

    public ContactPage(WebDriver driver) {
        super(driver);
    }
    @Step("Navigate to Contact Page.")
    public void navigateContactPage() {
        contactMenuItem.click();
    }
}
