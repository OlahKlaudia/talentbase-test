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
//    @FindBy(css = ".MuiFormControl-root:nth-child(1) input[type='checkbox']")
//    private WebElement checkboxSelect;

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

    public RegistrationHireTalentPage(WebDriver driver) {
        super(driver);
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
        checkboxSelect.click();
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
