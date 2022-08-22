package pages.linkspages;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HireTalentPage extends TalentbasePage {
    @FindBy(css = "a[href='/hire-talent']:nth-child(2)")
    private WebElement hireTalentMenuItem;
    private static final String HIRE_TALENT_PAGE = "/hire-talent";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(HIRE_TALENT_PAGE);
    }

    public HireTalentPage(WebDriver driver) {
        super(driver);
    }
    @Step("Navigate to Hire Talent Page.")
    public void navigateHireTalentPage() {
        hireTalentMenuItem.click();
    }
}
