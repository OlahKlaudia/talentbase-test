package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExperiencePage extends TalentbasePage {
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

    public String getTitleErrorText() {
        return titleError.getText();
    }

    public String getLocationErrorText() {
        return locationError.getText();
    }

    public String getCompanyErrorText() {
        return companyNameError.getText();
    }

    public void navigateWorkingExperience() {
        experienceLink.click();
        addExperience.click();
    }

    public void verifyLongTitle() {
        inputTitle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputTitle.sendKeys(LONG_CHAR);
    }

    public void verifyLongLocation() {
        inputLocation.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputLocation.sendKeys(LONG_CHAR);
    }

    public void verifyLongCompanyName() {
        companyName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        companyName.sendKeys(LONG_CHAR);
    }

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
    public void blankFieldsWorkingExperience() {
        inputTitle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputLocation.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        companyName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputTitle.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        inputLocation.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        companyName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        employmentType.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
    public WebElement verifyCheckbox() {
        checkBox.click();
        return endDate;
    }
}
