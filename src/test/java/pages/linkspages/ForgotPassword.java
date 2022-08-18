package pages.linkspages;

import mainbase.base.TalentbasePage;
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

    public void navigateForgotPasswordLink() {
        resetPasswordLink.click();
    }
    public void verifyInvalidEmail() {

        emailInput.sendKeys(INVALID_EMAIL);
    }
    public void validEmail(){
        emailInput.sendKeys(DELETE);
        emailInput.sendKeys(EMAIL);
        wait.until(ExpectedConditions.elementToBeClickable(registerCorporationButton));

    }
    public String getColor() {
        wait.until(ExpectedConditions.visibilityOf(registerCorporationButton));
        return registerCorporationButton.getCssValue("background-color");
    }
    public String getEmailErrorMessage() {
        return forgotPasswordErrorMessage.getText();
    }
}
