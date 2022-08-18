package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import pages.landingpage.FooterSection;
import pages.landingpage.WaitFooterElement;
import pages.landingpage.SrollToBottom;

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
    public WaitFooterElement scrollDown(){
        return new WaitFooterElement(driver);
    }
    public SrollToBottom waiting(){return new SrollToBottom(driver);}
}
