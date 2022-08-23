package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class LanguagePage extends TalentbasePage {
    public static final String LANGUAGE = "/languages";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(LANGUAGE);
    }
    public LanguagePage(WebDriver driver) {
        super(driver);
    }
}
