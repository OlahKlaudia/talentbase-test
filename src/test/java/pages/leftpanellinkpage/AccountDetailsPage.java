package pages.leftpanellinkpage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.registrationpage.WebelementsPage;

import java.io.File;
public class AccountDetailsPage extends WebelementsPage {

    @FindBy(css = "input[name='firstName']")
    public WebElement firstname;
    @FindBy(css = "input[name='lastName']")
    public WebElement lastname;
    @FindBy(css = "input[name='phoneNumber']")
    public WebElement phoneNumber;
    @FindBy(css = "input[name=\"name\"]")
    public WebElement name;
    @FindBy(css = "button[title=\"Clear\"]")
    public WebElement countryOfIncorporationClear;
    @FindBy(css = ".MuiAutocomplete-hasClearIcon:nth-child(6) button[title=\"Clear\"]")
    public WebElement careerClear;
    @FindBy(css = ".MuiAutocomplete-hasClearIcon:nth-child(4) button[title=\"Clear\"]")
    public WebElement nationalityClear;
    @FindBy(css = ".MuiFormControl-root .MuiFormHelperText-root")
    public WebElement phoneNumberErrorMessage;
    @FindBy(css = ".MuiFormControl-root:nth-child(2) .MuiFormHelperText-root")
    public WebElement zipCodeErrorMessage;
    @FindBy(css = "input[name='zipCode']")
    public WebElement zipCode;
    @FindBy(css = ".aos-animate .MuiBox-root .MuiBox-root")
    public WebElement uploadImage;
    @FindBy(css = ".MuiButton-root")
    public WebElement saveButton;
    public static final String ACCOUNT_DETAILS = "/account";
    public static final String SHORT_PHONE_NUMBER = "123";
    public static final String INVALID_PHONE_NUMBER = "123!@#";
    public static final String LONG_ZIPCODE = "123123123123123123123123123123123123123123123123";
    public static final String DELETE = Keys.chord(Keys.CONTROL, "a");
    private static final File FILE = new File("C:\\Users\\olahk\\Downloads\\image.png");

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

    public String getShortPhoneNumberText() {
        return phoneNumberErrorMessage.getText();
    }

    public String getZipCodeText() {
        return zipCodeErrorMessage.getText();
    }

    public String getButtonColor() {
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        return saveButton.getCssValue("background-color");
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
    }

    public void navigateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(accountLeftItem)).click();
    }

    public void blankFields() {
        firstname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        lastname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        phoneNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        action.moveToElement(nationalityClear).click().perform();
        action.moveToElement(careerClear).click().perform();
    }

    public void blankFieldsHireTalent() {
        name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        action.moveToElement(countryOfIncorporationClear).click().perform();
    }

    public String uploadImage() {
        final WebElement uploadFile = driver.findElement(By.cssSelector("input[type='file']"));
        uploadFile.sendKeys(FILE.getAbsolutePath());
        return uploadImage.getCssValue("background-image");
    }
}
