package pages.headerlinks;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends TalentbaseLandingPage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    public static final String OVERVIEW = "/profile";

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(OVERVIEW);
    }
}
