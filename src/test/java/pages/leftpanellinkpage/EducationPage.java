package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class EducationPage extends TalentbasePage {
    public static final String EDUCATION = "/education";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(EDUCATION);
    }
    public EducationPage(WebDriver driver) {
        super(driver);
    }
}
