package pages.linkspages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.WebelementsPage;

public class ForgotPassword extends WebelementsPage {
    public ForgotPassword(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[href='/reset']")
    private WebElement resetPasswordLink;
    private static final String FORGOT_PASSWORD_PAGE = "/reset";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(FORGOT_PASSWORD_PAGE);
    }
    @Step("Navigate to Forgot Password Page.")
    public void navigateForgotPasswordLink() {
        resetPasswordLink.click();
    }
    @Step("Type the input field invalid email.")
    public void verifyInvalidEmail() {
        emailInput.sendKeys(INVALID_EMAIL);
    }
    @Step("Type valid email into the input field.")
    public void validEmail(){
        emailInput.sendKeys(EMAIL);
        registerCorporationButton.click();
        wait.until(ExpectedConditions.visibilityOf(popUpNextButton));
    }
    @Step("Get email error message text.")
    public String getEmailErrorMessage() {
        return forgotPasswordErrorMessage.getText();
    }

}
