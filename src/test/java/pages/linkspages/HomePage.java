package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import pages.landingpage.FooterSection;
import pages.landingpage.ScrollToBottom;

public class HomePage extends TalentbasePage {
    private static final String HOME_PAGE = "https://dev.thetalentbase.com/";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(HOME_PAGE);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public FooterSection footerSection(){
        return new FooterSection(driver);
    }
    public ScrollToBottom scrollDown(){
        return new ScrollToBottom(driver);
    }
}
