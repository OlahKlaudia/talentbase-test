package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EducationPage extends TalentbasePage {
    public static final String EDUCATION = "/education";

    @FindBy(css = "[name=\"school\"]")
    public WebElement school;
    @FindBy(css = "[name=\"fieldOfStudy\"]")
    public WebElement fieldOfStudy;

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

    public void navigateEducationPage() {
        educationLink.click();
        addPlus.click();
    }

    public void fillEducation() {
        school.sendKeys(VALID_INPUT);
        fieldOfStudy.sendKeys(VALID_INPUT);
        checkBox.click();
        wait.until(ExpectedConditions.elementToBeClickable(startDate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(select2022)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectAug)).click();

        employmentType.click();
        bachelor.click();

        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        wait.until(ExpectedConditions.elementToBeClickable(saveSubmit)).click();
    }

}
