package mainbase.base;

import org.openqa.selenium.WebDriver;

public class TalentbasePage extends BasePage {

    public static final String TALENTBASE_URL = "https://dev.thetalentbase.com/";


    public TalentbasePage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(TALENTBASE_URL);
    }

}
