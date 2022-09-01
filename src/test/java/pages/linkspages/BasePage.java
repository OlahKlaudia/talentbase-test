package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class BasePage extends TalentbasePage {
    public BasePage(WebDriver driver) {
        super(driver);
    }
    private static final String BASE_PAGE = "/base";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(BASE_PAGE);
    }
}
