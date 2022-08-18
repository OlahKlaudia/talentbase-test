package pages.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.WebelementsPage;

public class LoginPage extends WebelementsPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyAllInputIsBlank() {
        usernameInput.sendKeys(DELETE);
        passwordInput.sendKeys(DELETE);
    }

    public void verifyButtonIsDisable() {
        usernameInput.click();
        passwordInput.click();
    }

    public void verifyInvalidPassword() {
        usernameInput.sendKeys(DELETE);
        passwordInput.sendKeys(WRONG_PASSWORD);
    }

    public void verifyValidCredentials() {
        usernameInput.sendKeys(EMAIL);
        passwordInput.sendKeys(PASSWORD);
    }

    public void signUpLink() {
        signUpAsTalentLink.click();
    }

    public String getColor() {
        wait.until(ExpectedConditions.visibilityOf(registerCorporationButton));
        return registerCorporationButton.getCssValue("background-color");
    }

    public String getPasswordErrorMessage() {
        return loginPasswordErrorMessage.getText();
    }
}
