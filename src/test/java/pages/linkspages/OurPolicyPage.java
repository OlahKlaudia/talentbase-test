package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class OurPolicyPage extends TalentbasePage {
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
