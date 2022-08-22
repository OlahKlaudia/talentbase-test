package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class LinkedInPage extends TalentbasePage {
    private static final String LINKED_IN_PAGE = "/linkedin";

    public LinkedInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }
    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(LINKED_IN_PAGE);
    }
}
