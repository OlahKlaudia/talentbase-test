package pages.registrationpage;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import mainbase.mainenum.AsTalentLinksEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.headerlinks.ApplyAsTalentPage;
import pages.footerlinkspages.OurPolicyPage;
import pages.headerlinks.SignInPage;
import pages.footerlinkspages.WebsiteTermsPage;

import java.time.Duration;

public class RegistrationHireTalentPage extends InputElementsPage {

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

    @Step("Get username error message text.")
    public String getUsernameErrorMessage() {
        return usernameErrorMessage.getText();
    }

    @Step("Get email error message text.")
    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    @Step("Get password error message text.")
    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    @Step("Clear all input field to verify button is disable.")
    public void verifyUserIsAllBlank() {
        usernameInput.clear();
        emailInput.clear();
        passwordInput.clear();

    }
    @Step("Clear the input fields, but select checkbox, and verify button is disable.")
    public void verifyCheckboxSelectedButtonDisable() {
        usernameInput.clear();
        emailInput.clear();
        passwordInput.clear();
        action.moveToElement(checkboxSelect).click().perform();
    }
    @Step("Type short username into the input field.")
    public void verifyShortUsername() {
        usernameInput.sendKeys(SHORT_USERNAME);
    }
    @Step("Type long username the input field,clear username input.")
    public void verifyLongUsername() {
        usernameInput.sendKeys(DELETE);
        usernameInput.sendKeys(LONG_USERNAME);
    }
    @Step("Delete username input field, and type invalid username.")
    public void verifyInvalidUsername() {
        usernameInput.sendKeys(DELETE);
        usernameInput.sendKeys(INVALID_USERNAME);
    }
    @Step("Delete username input field, and type username contains a space.")
    public void verifyUsernameWithSpaces() {
        usernameInput.sendKeys(DELETE);
        usernameInput.sendKeys(CONTAINS_SPACES_USERNAME);
    }

    @Step("Delete username input field, and type invalid email into the email input field.")
    public void verifyInvalidEmail() {
        usernameInput.sendKeys(DELETE);
        emailInput.sendKeys(INVALID_EMAIL);
    }

    @Step("Delete email input field, and type wrong password into the password input field.")
    public void shortPassword() {
        emailInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(WRONG_PASSWORD);
    }
    @Step("Delete password,type lond password.")
    public void longPassword() {
        passwordInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(LONG_PASSWORD);
    }
    @Step("Clear all inputs, and type valid username,email, and password.Check without select checkbox,button is disable")
    public void buttonIsDisableWithoutSelectCheckbox() {
        usernameInput.sendKeys(Keys.DELETE);
        emailInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(Keys.DELETE);
        usernameInput.sendKeys(USERNAME);
        emailInput.sendKeys(EMAIL);
        passwordInput.sendKeys(PASSWORD);
    }
    @Step("Clear all inputs, and type valid username,email, and password.")
    public void registrationAsTalent() {
        usernameInput.sendKeys(Keys.DELETE);
        emailInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(Keys.DELETE);
        usernameInput.sendKeys(USERNAME);
        emailInput.sendKeys(EMAIL);
        passwordInput.sendKeys(PASSWORD);
        checkboxSelect.click();
        button.click();
    }
    @Step("Hire Talent page,switch navigate link.")
    public TalentbaseLandingPage verifyLinksFunctionality(AsTalentLinksEnum element) {
        switch (element) {
            case registerCorporation:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(signUpAsTalentLink)).click();
                return new ApplyAsTalentPage(driver);
            case signIn:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
//                action.moveToElement(signInLink).click().perform();
                return new SignInPage(driver);
            case privacyPolicy:
                wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyLink)).click();
//                action.moveToElement(privacyPolicyLink).click().perform();
                return new OurPolicyPage(driver);
            case termsOfService:
                wait.until(ExpectedConditions.elementToBeClickable(termsOfServiceLink)).click();
//                action.moveToElement(termsOfServiceLink).click().perform();
                return new WebsiteTermsPage(driver);
        }
        return null;
    }
}
