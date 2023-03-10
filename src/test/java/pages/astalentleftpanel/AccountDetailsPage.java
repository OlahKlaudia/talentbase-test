package pages.astalentleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class AccountDetailsPage extends AsTalentBasePage {

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
    public static final String INVALID_NUMBER = "123!@#";
    public static final String LONG_ZIPCODE = "123123123123123123123123123123123123123123123123";

    public static final String DELETE = Keys.chord(Keys.CONTROL, "a");
    //    private static final File FILE = new File("C:\\Users\\olahk\\Pictures\\image.png");
    private static final File FILE = new File("C:" + File.separator + "Users" + File.separator + "olahk" + File.separator + "Pictures" + File.separator + "image.png");

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

    @Step("Get short phone number text.")
    public String getShortPhoneNumberText() {
        logger.info("Get short phone number text.");
        return phoneNumberErrorMessage.getText();
    }

    @Step("Get zip code text.")
    public String getZipCodeText() {
        logger.info("Get zip code text.");
        return zipCodeErrorMessage.getText();
    }

    @Step("Get button color.")
    public String getButtonColor() {
        logger.info("Get button color.");
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        return saveButton.getCssValue("background-color");
    }

    @Step("Fill the input field with short phone number.")
    public void shortPhoneNumber() {
        logger.info("Fill the form with short number.");
        phoneNumber.sendKeys(DELETE);
        phoneNumber.sendKeys(SHORT_PHONE_NUMBER);
    }

    @Step("Fill the input field with invalid phone number.")
    public void invalidPhoneNumber() {
        logger.info("Fill the form with invalid phone number.");
        phoneNumber.sendKeys(DELETE);
        phoneNumber.sendKeys(INVALID_NUMBER);
    }

    @Step("Fill the input field with invalid zip code.")
    public void invalidZipCode() {
        logger.info("Fill the form with invalid zip code.");
        zipCode.sendKeys(DELETE);
        zipCode.sendKeys(INVALID_NUMBER);
    }

    @Step("Fill the input field with long zip code.")
    public void longZipCode() {
        logger.info("Fill the form with long zip code.");
        zipCode.sendKeys(DELETE);
        zipCode.sendKeys(LONG_ZIPCODE);
    }

    @Step("Verify the button is disable with blank fields on the Account Details Page.")
    public void blankFields() {
        logger.info("Clears the fields.");
        firstname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        lastname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        phoneNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        action.moveToElement(nationalityClear).click().perform();
        action.moveToElement(careerClear).click().perform();
    }

    @Step("Verify the button is disable with blank fields on the Account Page.")
    public void blankFieldsInHireTalent() {
        logger.info("Clear the input fields.");
        name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        action.moveToElement(countryOfIncorporationClear).click().perform();
    }

    @Step("Verify the image is uploaded.")
    public String uploadImageAccount() {
        logger.info("Upload image in the Account page.");
        final WebElement uploadFile = driver.findElement(By.cssSelector("input[type='file']"));
        uploadFile.sendKeys(FILE.getAbsolutePath());
        return uploadImage.getCssValue("background-image");
    }

// nem tolti fel a kepet,mert nem m??k??dik

//    @Step("Verify the image is uploaded.")
//    public String uploadImage() {
//        final WebElement uploadFile = driver.findElement(By.cssSelector(".aos-animate .MuiBox-root .MuiBox-root svg"));
//        uploadFile.sendKeys(FILE.getAbsolutePath());
//        return uploadImage.getCssValue("background-image");
//    }
}
