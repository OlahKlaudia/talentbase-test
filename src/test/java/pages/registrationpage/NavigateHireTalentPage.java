package pages.registrationpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigateHireTalentPage extends TalentbasePage {
    @FindBy(css = "a[href='/hire-talent']:nth-child(2)")
    private WebElement hireTalentMenuItem;
    public static final String HIRE_TALENT_URL = "https://dev.thetalentbase.com/hire-talent";

    public NavigateHireTalentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(HIRE_TALENT_URL);
    }

    public void navigateHireTalentPage() {
        hireTalentMenuItem.click();
    }
}
