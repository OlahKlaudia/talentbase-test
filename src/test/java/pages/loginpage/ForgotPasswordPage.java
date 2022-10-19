package pages.loginpage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.InputElementsPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

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
        logger.info("Navigate to Forgot Password Page.");
        resetPasswordLink.click();
    }

    @Step("Type the input field invalid email.")
    public void verifyInvalidEmail() {
        logger.info("Type the input field invalid email.");
        emailInput.sendKeys(INVALID_EMAIL);
    }

    @Step("Type valid email into the input field.")
    public void verifyValidEmail() {
        logger.info("Type valid email into the input field.");
        emailInput.sendKeys(EMAIL);
        navigateFooterLinksPage().scrollDown();
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        wait.until(ExpectedConditions.visibilityOf(popUpNextButton));
    }

    @Step("Get email error message text.")
    public String getEmailErrorMessage() {
        logger.info("Get email error message text.");
        return forgotPasswordErrorMessage.getText();
    }

    @Step("Empty email into the input field.")
    public void verifyBlankEmail() {
        logger.info("Empty email into the input field.");
        emailInput.click();
        button.click();
    }

    @Step("Click Reset password Link in the email message.")
    public void navigateCreatePassword() {
        logger.info("Click Reset password Link in the email message.");
        assert driver.getWindowHandles().size() == 1;
        wait.until(ExpectedConditions.elementToBeClickable(resetPasswordEmailVerify)).click();
        String originalWindow = driver.getWindowHandle();
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
