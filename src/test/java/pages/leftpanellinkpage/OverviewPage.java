package pages.leftpanellinkpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends TalentbasePage {
    @FindBy(css = ".css-16khe3f svg")
    private WebElement contractAdministratorOverview;
    @FindBy(css = ".MuiGrid-item div:nth-child(3) svg g")
    private WebElement userTermsOverview;
    @FindBy(css = ".MuiGrid-item div[data-aos=\"fade-right\"]:nth-child(4) svg g")
    private WebElement aboutMeOverview;
    @FindBy(css = ".MuiGrid-item div:nth-child(5) svg g")
    private WebElement workingExperienceOverview;
    @FindBy(css = ".MuiGrid-item div[data-aos=\"fade-right\"]:nth-child(6) svg g")
    private WebElement educationOverview;
    @FindBy(css = ".MuiGrid-item div:nth-child(7) svg g")
    private WebElement certificatesOverview;
    @FindBy(css = ".MuiGrid-item div[data-aos=\"fade-right\"]:nth-child(8) svg g")
    private WebElement projectsOverview;
    @FindBy(css = ".MuiGrid-root:nth-child(2) svg:nth-child(1) g")
    private WebElement locationOverview;
    @FindBy(css = ".MuiGrid-container:nth-child(4) svg:nth-child(2) ")
    private WebElement socialNetworkLinksOverview;
    @FindBy(css = "div[data-aos=\"fade-left\"]:nth-child(6) svg g")
    private WebElement skillsOverview;
    @FindBy(css = "div[data-aos=\"fade-left\"]:nth-child(8) svg g")
    private WebElement languageOverview;
    @FindBy(css = ".MuiGrid-item div:nth-child(10) svg g")
    private WebElement hobbiesOverview;

    @FindBy(css = ".MuiTypography-root span")
    private WebElement clickOverview;
    public static final String OVERVIEW = "/profile";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(OVERVIEW);
    }
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Scroll down,wait footer visibility,return Page Object.")
    public TalentbasePage clickOverviewElements(LeftPanelElementsEnum element) {//todo scroll down and click the elements
        switch (element) {
//            case start:
//                wait.until(ExpectedConditions.elementToBeClickable(contractAdministrator)).click();
//                return new StartPage(driver);
//            case overview:
//                wait.until(ExpectedConditions.elementToBeClickable(overviewLink)).click();
//                return new OverviewPage(driver);
            case accountDetails:
                wait.until(ExpectedConditions.elementToBeClickable(contractAdministratorOverview)).click();
                return new AccountDetailsPage(driver);
            case introDescription:
                wait.until(ExpectedConditions.elementToBeClickable(aboutMeOverview)).click();
                return new IntroDescriptionPage(driver);
            case experience:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(workingExperienceOverview)).click();
                return new ExperiencePage(driver);
            case education:
//                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(educationOverview)).click();
                return new EducationPage(driver);
            case skills:
                wait.until(ExpectedConditions.elementToBeClickable(skillsOverview)).click();
                return new SkillsPage(driver);
            case language:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(languageOverview)).click();
                return new LanguagePage(driver);
            case certificates:
//                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(certificatesOverview)).click();
                return new CertificatesPage(driver);
            case projects:
//                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(projectsOverview)).click();
                return new ProjectsPage(driver);
            case hobbies:
//                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(hobbiesOverview)).click();
                return new HobbiesPage(driver);
            case socialLinks:
                wait.until(ExpectedConditions.elementToBeClickable(socialNetworkLinksOverview)).click();
                return new SocialLinksPage(driver);
            case userTerms:
                wait.until(ExpectedConditions.elementToBeClickable(userTermsOverview)).click();
                return new UserTermsPage(driver);
            case evolution:
                wait.until(ExpectedConditions.elementToBeClickable(locationOverview)).click();
                return new AccountDetailsPage(driver);
        }
        return null;
    }
}
