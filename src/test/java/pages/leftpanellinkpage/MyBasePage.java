package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class MyBasePage extends TalentbasePage {
    public MyBasePage(WebDriver driver) {
        super(driver);
    }
    public static final String TALENT = "/talent";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(TALENT);
    }
}
