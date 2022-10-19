package pages.hireleftpanel;

import mainbase.basepage.HireTalentBasePage;
import org.openqa.selenium.WebDriver;

public class TalentPage  extends HireTalentBasePage {
    public TalentPage(WebDriver driver) {
        super(driver);
    }
    public static final String TALENT = "/user";
    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(TALENT);
    }
}
