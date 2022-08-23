package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class ExperiencePage extends TalentbasePage {
    public static final String EXPERIENCE = "/experience";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(EXPERIENCE);
    }
    public ExperiencePage(WebDriver driver) {
        super(driver);
    }
}
