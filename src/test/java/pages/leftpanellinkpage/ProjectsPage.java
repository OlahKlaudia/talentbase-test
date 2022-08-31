package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
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
    private WebElement dees;
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
    public void navigateProject(){
        projectsLink.click();
        addPlus.click();
    }
    public void fillProjects() {
        name.sendKeys(VALID_INPUT);
        linkToProject.sendKeys(TALENTBASE_URL);
        additionalLinkName.sendKeys(VALID_INPUT);
        additionalLinkUrl.sendKeys(TALENTBASE_URL);

        dees.click();
//        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        wait.until(ExpectedConditions.elementToBeClickable(saveSubmit)).click();
    }
}
