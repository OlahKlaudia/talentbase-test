package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class HobbiesPage extends TalentbasePage {
    public static final String HOBBIES = "/hobbies";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(HOBBIES);
    }
    public HobbiesPage(WebDriver driver) {
        super(driver);
    }
}
