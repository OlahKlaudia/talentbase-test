package pages.headerlinks;

import io.qameta.allure.Step;
import mainbase.mainenum.LinksEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.InputElementsPage;

public class ContactPage extends InputElementsPage {
    @FindBy(css = "#mui-3-helper-text")
    private WebElement messageError;
    @FindBy(css = "#mui-2-helper-text")
    public WebElement contactEmailErrorMessage;
    @FindBy(css = "#mui-1-helper-text")
    private WebElement nameError;
    @FindBy(css = "#mui-4")
    private WebElement requestEmail;
    @FindBy(css = "#mui-4-helper-text")
    private WebElement requestEmailErrorMessage;
    @FindBy(css = "a[href='/contact']")
    private WebElement contactMenuItem;
    private static final String CONTACT_PAGE = "/contact";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(CONTACT_PAGE);
//        wait.until(ExpectedConditions.elementToBeClickable(button));
    }

    public ContactPage(WebDriver driver) {
        super(driver);
    }
    @Step("Navigate to Contact Page.")
    public void navigateContactPage() {
        contactMenuItem.click();
    }

    public String getEmailErrorMessageText() {
        return contactEmailErrorMessage.getText();
    }

    public String getNameErrorMessageText() {
        return nameError.getText();
    }

    public String getErrorMessageText() {
        return messageError.getText();
    }



    @Step("Click into name, email, textarea field, to show up error messages.")
    public void emptyInputs() {
        nameInput.click();
        emailInput.click();
        textarea.click();
        emailInput.click();
    }

    @Step("Type invalid email into the input field ")
    public void invalidEmail() {
        emailInput.sendKeys(INVALID_EMAIL);
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

    @Step("Click Talentbase mini menu icon links.")
    public String clickAboutPageLinkElements(LinksEnum element) {
        switch (element) {
            case linkedIn:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(linkedInMenuIcon));
                return linkedInMenuIcon.getAttribute("href");
            case facebook:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(facebookMenuIcon));
                return facebookMenuIcon.getAttribute("href");
            case twitter:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(twitterMenuIcon));
                return twitterMenuIcon.getAttribute("href");
            case mail:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(mailMenuItem));
                return mailMenuItem.getAttribute("href");
        }
        return null;
    }
}
