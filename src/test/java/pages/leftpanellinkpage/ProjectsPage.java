package pages.leftpanellinkpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsPage extends TalentbasePage {
    @FindBy(css = "input[name='name']")
    private WebElement name;
    @FindBy(css = "input[name='gitRepoLink']")
    private WebElement linkToProject;
    @FindBy(css = "input[name='additionalLink']")
    private WebElement additionalLinkUrl;
    @FindBy(css = "input[name='additionalLinkName']")
    private WebElement additionalLinkName;
    @FindBy(css = "textarea[name='description']")
    private WebElement description;
    @FindBy(css = ".footer")
    private WebElement footer;
    public static final String PROJECT = "/projects";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(PROJECT);

    }

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateProject() {
        projectsLink.click();
        addPlus.click();
    }

    public void fillProjects() {
        name.sendKeys(VALID_INPUT);
        linkToProject.sendKeys(TALENTBASE_URL);
        additionalLinkName.sendKeys(VALID_INPUT);
        additionalLinkUrl.sendKeys(TALENTBASE_URL);
        description.click();
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

    @Step("Get button background color.")
    public String getColor() {
        wait.until(ExpectedConditions.elementToBeClickable(saveSubmit));
        return saveSubmit.getCssValue("background-color");
    }
    public void blankFields() {
        name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        linkToProject.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        additionalLinkUrl.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}
