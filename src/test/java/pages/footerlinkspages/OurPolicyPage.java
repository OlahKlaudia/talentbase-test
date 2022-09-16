package pages.footerlinkspages;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;

public class OurPolicyPage extends TalentbaseLandingPage {
    private static final String OUR_POLICY_PAGE = "/privacyPolicy";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(OUR_POLICY_PAGE);
    }

    public OurPolicyPage(WebDriver driver) {
        super(driver);
    }
}
