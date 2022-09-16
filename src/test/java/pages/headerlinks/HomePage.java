package pages.headerlinks;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;
import pages.landingpage.WaitFooterElement;

public class HomePage extends TalentbaseLandingPage {

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(TALENTBASE_URL);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WaitFooterElement scrollDown(){
        return new WaitFooterElement(driver);
    }
    public SignInPage signInPage(){return new SignInPage(driver);}
    public ApplyAsTalentPage applyAsTalentPage(){return new ApplyAsTalentPage(driver);}
    public HireTalentPage hireTalentPage(){return new HireTalentPage(driver);}
}
