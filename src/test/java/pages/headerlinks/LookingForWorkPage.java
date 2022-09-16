package pages.headerlinks;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;

public class LookingForWorkPage extends TalentbaseLandingPage {
    private static final String LOOKING_FOR_WORK_PAGE = "/work";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(LOOKING_FOR_WORK_PAGE);
    }

    public LookingForWorkPage(WebDriver driver) {
        super(driver);
    }
}
