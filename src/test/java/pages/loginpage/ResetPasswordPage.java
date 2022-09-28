package pages.loginpage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.InputElementsPage;

public class ResetPasswordPage extends InputElementsPage {
    @FindBy(css = "input[name=\"confirmPassword\"]")
    private WebElement confirmPassword;
    @FindBy(css = "input[name=\"password\"]")
    private WebElement password;
    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }
    private static final String RESET_PASSWORD = "account/reset/";
    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(RESET_PASSWORD);
//        wait.until(ExpectedConditions.visibilityOf(header));
    }

    @Step("Create new password.")
    public void createNewPassword() {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(PASSWORD);
        confirmPassword.sendKeys(PASSWORD);
        button.click();
    }
}
