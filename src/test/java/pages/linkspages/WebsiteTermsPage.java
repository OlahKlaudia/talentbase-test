package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class WebsiteTermsPage extends TalentbasePage {
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
