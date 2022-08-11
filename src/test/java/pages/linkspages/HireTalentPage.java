package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class HireTalentPage extends TalentbasePage {
    private static final String HIRE_TALENT_PAGE = "/hire-talent";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(HIRE_TALENT_PAGE);
    }

    public HireTalentPage(WebDriver driver) {
        super(driver);
    }
}
