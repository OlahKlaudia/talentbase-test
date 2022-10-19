package pages.astalentleftpanel;

import mainbase.basepage.AsTalentBasePage;
import org.openqa.selenium.WebDriver;

public class HobbiesPage extends AsTalentBasePage {
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
