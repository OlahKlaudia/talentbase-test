package pages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
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
    public void scrollDownPartnersAndInvestors() {
        action.moveToElement(contactUsButton).click().perform();
    }
    public String getColor() {
        wait.until(ExpectedConditions.visibilityOf(registerCorporationButton));
        return registerCorporationButton.getCssValue("background-color");
    }
    public void emptyInputs() {
      nameInput.click();
      emailInput.click();
      textarea.click();
    }
    public void invalidEmail() {
        nameInput.sendKeys(DELETE);
        textarea.sendKeys(DELETE);
        emailInput.sendKeys(INVALID_EMAIL);
    }
    public void verifyWithSpaces() {
        nameInput.sendKeys(DELETE);
        emailInput.sendKeys(DELETE);
        textarea.sendKeys(DELETE);
        nameInput.sendKeys("  ");
        emailInput.sendKeys("  ");
        textarea.sendKeys("  ");
    }
    public void verifyWithLongCharacters() {
        nameInput.sendKeys(DELETE);
        emailInput.sendKeys(DELETE);
        textarea.sendKeys(DELETE);
        nameInput.sendKeys(LONG_USERNAME);
        emailInput.sendKeys(LONG_USERNAME);
        textarea.sendKeys(LONG_USERNAME);
    }
}
