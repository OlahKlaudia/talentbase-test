package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class StartPage extends TalentbasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }
    public static final String START = "/start";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(START);
    }
}
