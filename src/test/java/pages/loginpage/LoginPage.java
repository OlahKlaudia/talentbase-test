package pages.loginpage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.WebelementsPage;

public class LoginPage extends WebelementsPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Delete input field text.")
    public void verifyAllInputIsBlank() {
        usernameInput.sendKeys(DELETE);
        passwordInput.sendKeys(DELETE);
    }

    @Step("Click into the input field, and verify error message is available.")
    public void verifyButtonIsDisable() {
        usernameInput.click();
        passwordInput.click();
    }

    @Step("Delete username input field, and type wrong password.")
    public void verifyInvalidPassword() {
        usernameInput.sendKeys(DELETE);
        passwordInput.sendKeys(WRONG_PASSWORD);
    }
    @Step("Type valid email into the input fields.")
    public void verifyValidCredentials() {
        usernameInput.sendKeys(EMAIL);
        passwordInput.sendKeys(PASSWORD);
    }
    @Step("Click Sign up link.")
    public void signUpLink() {
        signUpAsTalentLink.click();
    }

    @Step("Get password error message text.")
    public String getPasswordErrorMessage() {
        return loginPasswordErrorMessage.getText();
    }
}
