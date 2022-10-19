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
        logger.info("Get username error message text.");
        return usernameErrorMessage.getText();
    }

    @Step("Get email error message text.")
    public String getEmailErrorMessage() {
        logger.info("Get email error message text.");
        return emailErrorMessage.getText();
    }

    @Step("Get password error message text.")
    public String getPasswordErrorMessage() {
        logger.info("Get password error message text.");
        return passwordErrorMessage.getText();
    }

    @Step("Clear all input field to verify button is disable.")
    public void verifyUserIsAllBlank() {
        logger.info("Clear all input field to verify button is disable.");
        usernameInput.clear();
        emailInput.clear();
        passwordInput.clear();
    }
    @Step("Clear the input fields, but select checkbox, and verify button is disable.")
    public void verifyCheckboxSelectedButtonDisable() {
        logger.info("Clear the input fields, but select checkbox, and verify button is disable.");
        usernameInput.clear();
        emailInput.clear();
        passwordInput.clear();
        action.moveToElement(checkboxSelect).click().perform();
    }
    @Step("Type short username into the input field.")
    public void verifyShortUsername() {
        logger.info("Type short username into the input field.");
        usernameInput.sendKeys(SHORT_USERNAME);
    }
    @Step("Type long username the input field,clear username input.")
    public void verifyLongUsername() {
        logger.info("Type long username the input field,clear username input.");
        usernameInput.sendKeys(DELETE);
        usernameInput.sendKeys(LONG_USERNAME);
    }
    @Step("Delete username input field, and type invalid username.")
    public void verifyInvalidUsername() {
        logger.info("Delete username input field, and type invalid username.");
        usernameInput.sendKeys(DELETE);
        usernameInput.sendKeys(INVALID_USERNAME);
    }
    @Step("Delete username input field, and type username contains a space.")
    public void verifyUsernameWithSpaces() {
        logger.info("Delete username input field, and type username contains a space.");
        usernameInput.sendKeys(DELETE);
        usernameInput.sendKeys(CONTAINS_SPACES_USERNAME);
    }

    @Step("Delete username input field, and type invalid email into the email input field.")
    public void verifyInvalidEmail() {
        logger.info("Delete username input field, and type invalid email into the email input field.");
        usernameInput.sendKeys(DELETE);
        emailInput.sendKeys(INVALID_EMAIL);
    }

    @Step("Delete email input field, and type wrong password into the password input field.")
    public void shortPassword() {
        logger.info("Delete email input field, and type wrong password into the password input field.");
        emailInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(WRONG_PASSWORD);
    }
    @Step("Delete password,type long password.")
    public void longPassword() {
        logger.info("Delete password,type long password.");
        passwordInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(LONG_PASSWORD);
    }
    @Step("Clear all inputs, and type valid username,email, and password.Check without select checkbox,button is disable.")
    public void buttonIsDisableWithoutSelectCheckbox() {
        logger.info("Clear all inputs, and type valid username,email, and password.Check without select checkbox,button is disable.");
        usernameInput.sendKeys(Keys.DELETE);
        emailInput.sendKeys(Keys.DELETE);
        passwordInput.sendKeys(Keys.DELETE);
        usernameInput.sendKeys(USERNAME);
        emailInput.sendKeys(EMAIL);
        passwordInput.sendKeys(PASSWORD);
    }
    @Step("Clear all inputs, and type valid username,email, and password.")
    public void registrationAsTalent() {
        logger.info("Clear all inputs, and type valid username,email, and password.");
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
            case REGISTER_CORPORATION:
                logger.info(element.toString());
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(signUpAsTalentLink)).click();
                return new ApplyAsTalentPage(driver);
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
