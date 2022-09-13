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
    }
    public void waitButton() throws InterruptedException {
        int maxWait = 1000 / 200;
        int i = 1;
        do {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(saveSubmit)).click();
                i++;
                System.out.println("how many times it goes through the do while" + i);
                break;
            } catch (Exception e) {
                Thread.sleep(200);
            }
        } while (i < maxWait);
    }
    public void blankFields() {
        school.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        fieldOfStudy.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}
