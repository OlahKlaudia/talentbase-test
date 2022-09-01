package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import pages.landingpage.FooterSection;
import pages.landingpage.HeaderSection;
import pages.landingpage.WaitFooterElement;
import pages.landingpage.ScrollToBottom;

public class HomePage extends TalentbasePage {

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

    public FooterSection footerSection(){
        return new FooterSection(driver);
    }
    public WaitFooterElement scrollDown(){
        return new WaitFooterElement(driver);
    }
    public ScrollToBottom waiting(){return new ScrollToBottom(driver);}
    public HeaderSection headerSection(){return new HeaderSection(driver);}
    public SignInPage signInPage(){return new SignInPage(driver);}
    public ApplyAsTalentPage applyAsTalentPage(){return new ApplyAsTalentPage(driver);}
    public PartnersAndInvestorsPage partnersAndInvestorsPage(){return new PartnersAndInvestorsPage(driver);}
    public HireTalentPage hireTalentPage(){return new HireTalentPage(driver);}
}
