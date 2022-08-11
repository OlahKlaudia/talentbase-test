package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class PartnersAndInvestorsPage extends TalentbasePage {
    private static final String PARTNER_INVESTORS = "/partners";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(PARTNER_INVESTORS);
    }

    public PartnersAndInvestorsPage(WebDriver driver) {
        super(driver);
    }
}
