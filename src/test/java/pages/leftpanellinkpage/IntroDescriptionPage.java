package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class IntroDescriptionPage extends TalentbasePage {
    public static final String INTRO_DESCRIPTION = "/intro";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(INTRO_DESCRIPTION);
    }
    public IntroDescriptionPage(WebDriver driver) {
        super(driver);
    }
}
