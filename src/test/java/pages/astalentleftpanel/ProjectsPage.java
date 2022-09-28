package pages.astalentleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsPage extends AsTalentBasePage {
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

    public static final String PROJECT = "/projects";
    public static final String PROJECT_URL = "https://dev.thetalentbase.com/";
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

    @Step("Fill with valid data.")
    public void fillProjects() {
        name.sendKeys(VALID_INPUT);
        linkToProject.sendKeys(PROJECT_URL);
        additionalLinkName.sendKeys(VALID_INPUT);
        additionalLinkUrl.sendKeys(PROJECT_URL);
        description.click();
    }

    @Step("Verify button is disable with blank fields.")
    public void blankFields() {
        name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        linkToProject.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        additionalLinkUrl.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}
