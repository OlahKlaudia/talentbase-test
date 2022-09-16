package pages.loginpage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.registrationpage.InputElementsPage;

public class LoginPage extends InputElementsPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Delete input field text.")
    public void verifyAllInputIsBlank() {
        usernameInput.sendKeys(DELETE);
        passwordInput.sendKeys(DELETE);
        usernameInput.click();
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
    @Step("Type valid email into the input fields,and log in.")
    public void login() {
        usernameInput.sendKeys(USERNAME);
        passwordInput.sendKeys(PASSWORD);
        button.click();
    }
    @Step("Type valid email into the input fields,and log in.")
    public void loginHireTalent()  {
        usernameInput.sendKeys(USERNAME_AS_HIRE);
        passwordInput.sendKeys(PASSWORD);
        button.click();
    }
    @Step("Click Sign up link.")
    public void signUpLink() {
        signUpAsTalentLink.click();
    }

    @Step("Get password error message text.")
    public String getPasswordErrorMessage() {
        return loginPasswordErrorMessage.getText();
    }
    @Step("Get password error message text.")
    public String getUsernameErrorMessage() {
        return usernameErrorMessage.getText();
    }


}
