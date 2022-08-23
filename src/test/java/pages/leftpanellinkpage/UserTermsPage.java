package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class UserTermsPage extends TalentbasePage {
    public static final String USER_TERMS = "/terms";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(USER_TERMS);
    }
    public UserTermsPage(WebDriver driver) {
        super(driver);
    }
}
