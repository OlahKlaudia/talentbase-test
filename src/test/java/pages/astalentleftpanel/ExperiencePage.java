package pages.astalentleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExperiencePage extends AsTalentBasePage {
    public static final String EXPERIENCE = "/experience";

    @FindBy(css = ".MuiBox-root:nth-child(1) div svg")
    private WebElement addExperience;
    @FindBy(css = ".MuiInput-root input[name='title']")
    private WebElement inputTitle;
    @FindBy(css = ".MuiOutlinedInput-root input[name='location']")
    private WebElement inputLocation;
    @FindBy(css = ".MuiOutlinedInput-root input[name='companyName']")
    private WebElement companyName;
    @FindBy(css = ".MuiOutlinedInput-root .Mui-disabled")
    private WebElement endDate;
    @FindBy(css = ".MuiSelect-select")
    public WebElement employmentType;
    @FindBy(css = "ul li[data-value=\"Full Time\"]")
    public WebElement selectFullTime;
    @FindBy(css = ".MuiFormControl-root:nth-child(1) .MuiFormHelperText-root")
    public WebElement titleError;
    @FindBy(css = ".MuiGrid-root:nth-child(2) .MuiFormHelperText-root")
    public WebElement companyNameError;
    @FindBy(css = ".MuiFormControl-root:nth-child(2)  p")//nem teljesen okés
    public WebElement locationError;

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(EXPERIENCE);
    }

    public ExperiencePage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify get error message when type long title into the title input field.")
    public String verifyLongTitle() {
        inputTitle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputTitle.sendKeys(LONG_CHAR);
        return titleError.getText();
    }

    @Step("Verify get error message when type long location into the location input field.")
    public String verifyLongLocation() {
        inputLocation.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputLocation.sendKeys(LONG_CHAR);
        return locationError.getText();
    }

    @Step("Verify get error message when type long company name into the company name input field.")
    public String verifyLongCompanyName() {
        companyName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        companyName.sendKeys(LONG_CHAR);
        return companyNameError.getText();
    }

    @Step("Fill with valid data.")
    public void fillWorkingExperience() {
        inputTitle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputLocation.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        companyName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        inputTitle.sendKeys(VALID_INPUT);
        inputLocation.sendKeys(VALID_INPUT);
        companyName.sendKeys(VALID_INPUT);

        checkBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(startDate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(select2022)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectAug)).click();

        employmentType.click();
        selectFullTime.click();

        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        wait.until(ExpectedConditions.elementToBeClickable(saveSubmit)).click();
    }

    @Step("Verify the button is disable with blank fields.")
    public void blankFieldsWorkingExperience() {
        inputTitle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputLocation.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        companyName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputTitle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputLocation.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        companyName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        employmentType.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
    @Step("Click still work here checkbox,get checkbox color.")
    public String verifyCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
        return checkBox.getCssValue("color");
    }
    @Step("Get end date webelement.")
    public WebElement getEndDate(){
        return endDate;
    }
}
