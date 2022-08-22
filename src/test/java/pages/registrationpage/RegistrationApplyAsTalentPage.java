package pages.registrationpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.AsTalentLinksEnum;
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
    @Step("In Apply as Talent Page,navigate links.")
    public TalentbasePage verifyLinksFunctionality(AsTalentLinksEnum element) {
        switch (element) {
            case registerCorporation:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(registerCorporation)).click();
//
//                action.moveToElement(registerCorporation).click().perform();
                return new HireTalentPage(driver);
            case signIn:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
                return new SignInPage(driver);
            case privacyPolicy:
                wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink)).click();
                return new OurPolicyPage(driver);
            case termsOfService:
                wait.until(ExpectedConditions.elementToBeClickable(termsOfServiceLink)).click();
                return new WebsiteTermsPage(driver);
        }
        return null;
    }
}
