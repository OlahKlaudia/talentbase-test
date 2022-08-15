package pages.registrationpage;

import mainbase.base.TalentbasePage;
import mainbase.browserenum.FooterElementsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.linkspages.ApplyAsTalentPage;
import pages.linkspages.OurPolicyPage;
import pages.linkspages.SignInPage;
import pages.linkspages.WebsiteTermsPage;

public class RegistrationHireTalentPage extends TalentbasePage {

    @FindBy(css = "input[name='username']")
    private WebElement usernameInput;

    @FindBy(css = "input[name='email']")
    private WebElement emailInput;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = ".MuiFormControl-root:nth-child(1) .MuiSvgIcon-root")
    private WebElement checkboxSelect;

    @FindBy(css = "p:nth-child(1) a[href='/register']")
    private WebElement signUpAsTalentLink;

    @FindBy(css = "p:nth-child(1) a[href='/login']")
    private WebElement signInLink;

    @FindBy(css = "p:nth-child(2) a[href='/termsOfService']")
    private WebElement termsOfServiceLink;

    @FindBy(css = "p:nth-child(2) a[href='/privacyPolicy']")
    private WebElement privacyPolicyLink;

    @FindBy(css = "button[type='submit']")
    private WebElement registerCorporationButton;

    @FindBy(css = ".MuiFormHelperText-root")
    private WebElement usernameErrorMessage;

    @FindBy(css = "div:nth-child(2) .MuiFormHelperText-root")
    private WebElement emailErrorMessage;
    private static final String SHORT_USERNAME="test";
    private static final String LONG_USERNAME="mSLsbjtFEnwbhVxZTJgNhq4pe7t6pnciex3XFSYOYWDAjXKRn5y";
    private static final String INVALID_USERNAME="test12#";
    private static final String CONTAINS_SPACES_USERNAME="test username";
    private static final String INVALID_EMAIL="test+talentbase @digitalarcher.dev";

    public RegistrationHireTalentPage(WebDriver driver) {
        super(driver);
    }
    public String getUsernameErrorMessage(){
        return usernameErrorMessage.getText();
    }
    public String getEmailErrorMessage(){
        return emailErrorMessage.getText();
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
        usernameInput.clear();
        usernameInput.sendKeys(LONG_USERNAME);
    }
    public void verifyInvalidUsername() {
        usernameInput.clear();
        usernameInput.sendKeys(INVALID_USERNAME);
    }
    public void verifyUsernameWithSpaces() {
        usernameInput.clear();
        usernameInput.sendKeys(CONTAINS_SPACES_USERNAME);
    }
    public void verifyInvalidEmail() {
        usernameInput.clear();
        emailInput.sendKeys(INVALID_EMAIL);
    }
    public String getColor() {
        wait.until(ExpectedConditions.visibilityOf(registerCorporationButton));
        return registerCorporationButton.getCssValue("background-color");
    }

    public Object verifyButtonsFuncionality(FooterElementsEnum element) {
        switch (element) {
            case partnersAndInvestors:
                signUpAsTalentLink.click();
                return new ApplyAsTalentPage(driver);
            case contactus:
                signInLink.click();
                return new SignInPage(driver);
            case ourPolicy:
                privacyPolicyLink.click();
                return new OurPolicyPage(driver);
            case websiteTerms:
                termsOfServiceLink.click();
                return new WebsiteTermsPage(driver);
        }
        return null;
    }
}
