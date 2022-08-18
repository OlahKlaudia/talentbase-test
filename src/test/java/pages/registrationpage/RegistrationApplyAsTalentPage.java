package pages.registrationpage;

import mainbase.base.TalentbasePage;
import mainbase.browserenum.FooterElementsEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.linkspages.*;

import java.time.Duration;

public class RegistrationApplyAsTalentPage extends WebelementsPage {
    public RegistrationApplyAsTalentPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(webElements().termsOfServiceLink));
    }
    WebelementsPage webElements(){
        return new WebelementsPage(driver);
    }
    public TalentbasePage verifyLinksFunctionality(FooterElementsEnum element) {
        switch (element) {
            case whyUsLink:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                action.moveToElement(registerCorporation).click().perform();
                return new HireTalentPage(driver);
            case clients:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                action.moveToElement(signInLink).click().perform();
                return new SignInPage(driver);
            case partnersAndInvestors:
                action.moveToElement(privacyPolicyLink).click().perform();
                return new OurPolicyPage(driver);
            case contactus:
                action.moveToElement(termsOfServiceLink).click().perform();
                return new WebsiteTermsPage(driver);
        }
        return null;
    }
}
