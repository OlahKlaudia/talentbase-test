package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class FacebookPage extends TalentbasePage {
    public FacebookPage(WebDriver driver) {
        super(driver);
    }
    private static final String FACEBOOK_PAGE = "facebook";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(FACEBOOK_PAGE);
    }
}
