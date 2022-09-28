package pages.headerlinks;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;

public class HireTalentPage extends TalentbaseLandingPage {
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
}
