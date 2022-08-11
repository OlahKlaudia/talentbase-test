package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class SignInPage extends TalentbasePage {
    private static final String SIGN_IN_PAGE = "/login";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(SIGN_IN_PAGE);
    }

    public SignInPage(WebDriver driver) {
        super(driver);
    }
}
