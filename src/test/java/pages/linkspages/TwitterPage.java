package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class TwitterPage extends TalentbasePage {
    public TwitterPage(WebDriver driver) {
        super(driver);
    }
    private static final String TWITTER_PAGE = "/twitter";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(TWITTER_PAGE);
    }
}
