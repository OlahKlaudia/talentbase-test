package pages.footerlinkspages;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;

public class WebsiteTermsPage extends TalentbaseLandingPage {
    private static final String WEBSITE_TERMS_PAGE = "/termsOfService";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(WEBSITE_TERMS_PAGE);
    }

    public WebsiteTermsPage(WebDriver driver) {
        super(driver);
    }
}
