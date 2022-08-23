package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDetailsPage extends TalentbasePage {

    @FindBy(css = "input[name='firstname']")
    public WebElement firstname;
    @FindBy(css = "textarea[name='lastname']")
    public WebElement lastname;
    @FindBy(css = "input[name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(css = ".MuiFormControl-root .MuiFormHelperText-root")
    public WebElement phoneNumberErrorMessage;
    @FindBy(css = ".MuiFormControl-root:nth-child(2) .MuiFormHelperText-root")
    public WebElement zipCodeErrorMessage;
    @FindBy(css = "input[name='zipCode']")
    public WebElement zipCode;

    @FindBy(css = ".MuiButton-root")
    public WebElement save;
    public static final String ACCOUNT_DETAILS = "/account";
    public static final String SHORT_PHONE_NUMBER = "123";
    public static final String INVALID_PHONE_NUMBER = "123!@#";
    public static final String LONG_ZIPCODE = "123123123123123123123123123123123123123123123123";
    public static final String DELETE = Keys.chord(Keys.CONTROL, "a");

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(ACCOUNT_DETAILS);
    }

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }
    public String getShortPhoneNumberText(){
        return phoneNumberErrorMessage.getText();
    }
    public String getZipCodeText(){
        return zipCodeErrorMessage.getText();
    }

    public void shortPhoneNumber() {
        phoneNumber.sendKeys(DELETE);
        phoneNumber.sendKeys(SHORT_PHONE_NUMBER);
    }

    public void invalidPhoneNumber() {
        phoneNumber.sendKeys(DELETE);
        phoneNumber.sendKeys(INVALID_PHONE_NUMBER);
    }

    public void invalidZipCode() {
        zipCode.sendKeys(DELETE);
        zipCode.sendKeys(INVALID_PHONE_NUMBER);
    }

    public void longZipCode() {
        zipCode.sendKeys(DELETE);
        zipCode.sendKeys(LONG_ZIPCODE);
    }
    public void navigateAccountDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(accountDetailsLink)).click();
//        accountDetailsLink.click();
    }
}
