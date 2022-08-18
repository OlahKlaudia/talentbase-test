package pages.registrationpage;

import mainbase.base.TalentbasePage;
import mainbase.browserenum.FooterElementsEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.linkspages.ApplyAsTalentPage;
import pages.linkspages.OurPolicyPage;
import pages.linkspages.SignInPage;
import pages.linkspages.WebsiteTermsPage;

import java.time.Duration;

public class RegistrationHireTalentPage extends WebelementsPage {

    public RegistrationHireTalentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }
    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(signInLink));
    }


    public String getUsernameErrorMessage() {
        return usernameErrorMessage.getText();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public void verifyUserIsAllBlank() {
        usernameInput.clear();
        emailInput.clear();
        passwordInput.clear();

    }

    public void verifyCheckboxSelectedButtonDisable() {
        usernameInput.clear();
        emailInput.clear();
        passwordInput.clear();
        action.moveToElement(checkboxSelect).click().perform();
    }

    public void verifyShortUsername() {
        usernameInput.sendKeys(SHORT_USERNAME);

    }

    public void verifyLongUsername() {
        usernameInput.sendKeys(DELETE);
        usernameInput.sendKeys(LONG_USERNAME);
    }

    public void verifyInvalidUsername() {
        usernameInput.sendKeys(DELETE);
        usernameInput.sendKeys(INVALID_USERNAME);
    }

    public void verifyUsernameWithSpaces() {
        usernameInput.sendKeys(DELETE);
        usernameInput.sendKeys(CONTAINS_SPACES_USERNAME);
    }

    public void verifyInvalidEmail() {
        usernameInput.sendKeys(DELETE);
        emailInput.sendKeys(INVALID_EMAIL);
    }

    public void shortPassword() {
        emailInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(WRONG_PASSWORD);
    }

    public void longPassword() {
        passwordInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(LONG_PASSWORD);
    }

    public void buttonIsDisableWithoutSelectCheckbox() {
        usernameInput.clear();
        emailInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys(USERNAME);
        emailInput.sendKeys(EMAIL);
        passwordInput.sendKeys(PASSWORD);
    }

    public String getColor() {
        wait.until(ExpectedConditions.visibilityOf(registerCorporationButton));
        return registerCorporationButton.getCssValue("background-color");
    }

    public TalentbasePage verifyButtonsFunctionality(FooterElementsEnum element) {
        switch (element) {
            case whyUsLink:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                action.moveToElement(signUpAsTalentLink).click().perform();
                return new ApplyAsTalentPage(driver);
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
