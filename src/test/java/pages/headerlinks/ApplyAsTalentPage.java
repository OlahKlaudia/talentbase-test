package pages.headerlinks;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;

public class ApplyAsTalentPage extends TalentbaseLandingPage {
    private static final String APPLY_AS_TALENT = "/register";

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(APPLY_AS_TALENT);
    }

    public ApplyAsTalentPage(WebDriver driver) {
        super(driver);
    }
}
