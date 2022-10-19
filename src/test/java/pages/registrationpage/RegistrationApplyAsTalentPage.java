package pages.registrationpage;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import mainbase.mainenum.AsTalentLinksEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.headerlinks.HireTalentPage;
import pages.headerlinks.SignInPage;
import pages.footerlinkspages.*;

import java.time.Duration;

public class RegistrationApplyAsTalentPage extends InputElementsPage {
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
    InputElementsPage webElements(){
        return new InputElementsPage(driver);
    }
    @Step("In Apply as Talent Page,navigate links.")
    public TalentbaseLandingPage verifyLinksFunctionality(AsTalentLinksEnum element) {
        switch (element) {
            case REGISTER_CORPORATION:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(registerCorporation)).click();
//                action.moveToElement(registerCorporation).click().perform();
                return new HireTalentPage(driver);
            case SIGN_IN:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
                return new SignInPage(driver);
            case PRIVACY_POLICY:
                logger.info(element.toString());
                wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink)).click();
                return new OurPolicyPage(driver);
            case TERMS_OF_SERVICE:
                logger.info(element.toString());
                wait.until(ExpectedConditions.elementToBeClickable(termsOfServiceLink)).click();
                return new WebsiteTermsPage(driver);
        }
        return null;
    }
}
