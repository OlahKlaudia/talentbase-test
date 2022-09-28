package pages.astalentleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EducationPage extends AsTalentBasePage {

    @FindBy(css = "[name=\"school\"]")
    public WebElement school;
    @FindBy(css = "[name=\"fieldOfStudy\"]")
    public WebElement fieldOfStudy;
    @FindBy(css = ".MuiSelect-select")
    public WebElement employmentType;
    @FindBy(css = "ul li[data-value=\"Other\"]")
    public WebElement bachelor;
    public static final String EDUCATION = "/education";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(EDUCATION);
    }

    public EducationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill with valid data.")
    public void fillEducation() {
        school.sendKeys(VALID_INPUT);
        fieldOfStudy.sendKeys(VALID_INPUT);
        checkBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(startDate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(select2022)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectAug)).click();

        employmentType.click();
        bachelor.click();
    }

    @Step("Verify the button is disable with blank fields.")
    public void blankFields() {
        school.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        fieldOfStudy.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}
