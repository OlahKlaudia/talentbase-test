package pages.loginpage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.InputElementsPage;

public class ForgotPasswordPage extends InputElementsPage {
    @FindBy(css = "a[href='/reset']")
    private WebElement resetPasswordLink;
    @FindBy(css = "table:nth-child(1) tr a")
    private WebElement resetPasswordEmailVerify;

    private static final String FORGOT_PASSWORD_PAGE = "/reset";

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

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
    public void verifyValidEmail() {
        emailInput.sendKeys(EMAIL);
        button.click();
        wait.until(ExpectedConditions.visibilityOf(popUpNextButton));
    }

    @Step("Get email error message text.")
    public String getEmailErrorMessage() {
        return forgotPasswordErrorMessage.getText();
    }

    @Step("Empty email into the input field.")
    public void verifyBlankEmail() {
        emailInput.click();
        button.click();
    }
    @Step("Click Reset password Link in the email message.")
    public ResetPasswordPage navigateCreatePassword() {
        wait.until(ExpectedConditions.elementToBeClickable(resetPasswordEmailVerify)).click();
        return new ResetPasswordPage(driver);
    }
}
