package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class SocialLinksPage extends TalentbasePage {
    public static final String SOCIAL_LINK = "/social";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(SOCIAL_LINK);
    }
    public SocialLinksPage(WebDriver driver) {
        super(driver);
    }
}
