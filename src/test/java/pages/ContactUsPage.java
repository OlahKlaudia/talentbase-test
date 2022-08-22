package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.WebelementsPage;

public class ContactUsPage extends WebelementsPage {

    @FindBy(css = ".MuiGrid-root:nth-child(1) button")
    private WebElement contactUsButton;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
//        wait.until(ExpectedConditions.elementToBeClickable(contactUsButton));
    }
    @Step("Click contact us button.")
    public void clickContactUsButton() {
        action.moveToElement(contactUsButton).click().perform();
    }

    @Step("Click into name, email, textarea field, to show up error messages.")
    public void emptyInputs() {
      nameInput.click();
      emailInput.click();
      textarea.click();
    }
    @Step("Type invalid email into the input field ")
    public void invalidEmail() {
        nameInput.sendKeys(DELETE);
        textarea.sendKeys(DELETE);
        emailInput.sendKeys(INVALID_EMAIL);
    }
    @Step("Type white spaces into the input fields.")
    public void verifyWithSpaces() {
        nameInput.sendKeys(DELETE);
        emailInput.sendKeys(DELETE);
        textarea.sendKeys(DELETE);
        nameInput.sendKeys("  ");
        emailInput.sendKeys("  ");
        textarea.sendKeys("  ");
    }
    @Step("Type long characters into the input fields.")
    public void verifyWithLongCharacters() {
        nameInput.sendKeys(DELETE);
        emailInput.sendKeys(DELETE);
        textarea.sendKeys(DELETE);
        nameInput.sendKeys(LONG_USERNAME);
        emailInput.sendKeys(LONG_USERNAME);
        textarea.sendKeys(LONG_USERNAME);
    }
}
