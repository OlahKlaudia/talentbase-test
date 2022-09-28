package pages.headerlinks;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;

public class AboutPage extends TalentbaseLandingPage {
    private static final String ABOUT_PAGE = "/about";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(ABOUT_PAGE);
    }

    public AboutPage(WebDriver driver) {
        super(driver);
    }

}
