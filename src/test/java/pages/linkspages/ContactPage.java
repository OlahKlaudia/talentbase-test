package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class ContactPage extends TalentbasePage {
    private static final String CONTACT_PAGE = "/contact";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(CONTACT_PAGE);
    }

    public ContactPage(WebDriver driver) {
        super(driver);
    }
}
