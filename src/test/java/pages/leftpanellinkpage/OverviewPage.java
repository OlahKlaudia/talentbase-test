package pages.leftpanellinkpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.astalentpage.waitUntil;

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
    @FindBy(css = ".MuiGrid-container:nth-child(4) svg:nth-child(2)")
    private WebElement socialNetworkLinksOverview;
    @FindBy(css = ".MuiGrid-container:nth-child(4) span")
    private WebElement clickToSeeOverview;
    @FindBy(css = "div[data-aos=\"fade-left\"]:nth-child(6) svg g")
    private WebElement skillsOverview;
    @FindBy(css = "div[data-aos=\"fade-left\"]:nth-child(8) svg g")
    private WebElement languageOverview;
    @FindBy(css = ".MuiGrid-item div:nth-child(10) svg g")
    private WebElement hobbiesOverview;

    @FindBy(css = ".MuiTypography-root span")
    private WebElement clickOverview;
    @FindBy(css = "[data-aos=\"fade-right\"]:nth-child(3) .MuiLink-underlineAlways")
    private WebElement exportProfileAsPdf;
    @FindBy(css = "[data-aos=\"fade-right\"]:nth-child(3)  div[style=\"flex-grow: 1; margin-top: auto;\"] p")
    private WebElement salaryHover;
    public static final String OVERVIEW = "/profile";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(OVERVIEW);
        wait.until(ExpectedConditions.visibilityOf(contractAdministratorOverview));

    }
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickExportProfile(){
        exportProfileAsPdf.click();
    }

    public  waitUntil scroll(){return new   waitUntil(driver);}
    @Step("Scroll down,wait left panel items visibility,return Page Object.")
    public TalentbasePage clickOverviewElements(LeftPanelElementsEnum element) {
        //todo export profile as PDF
        switch (element) {
            case accountDetails:
                wait.until(ExpectedConditions.elementToBeClickable(contractAdministratorOverview)).click();
                return new AccountDetailsPage(driver);
            case introDescription:
                wait.until(ExpectedConditions.elementToBeClickable(aboutMeOverview)).click();
                return new IntroDescriptionPage(driver);
            case experience:
                scroll().waitUntils();
                wait.until(ExpectedConditions.elementToBeClickable(workingExperienceOverview)).click();
                return new ExperiencePage(driver);
            case education:
                scroll().waitUntils();
                wait.until(ExpectedConditions.elementToBeClickable(educationOverview)).click();
                return new EducationPage(driver);
            case skills:
                wait.until(ExpectedConditions.elementToBeClickable(skillsOverview)).click();
                return new SkillsPage(driver);
            case language:
                scroll().waitUntils();
                wait.until(ExpectedConditions.visibilityOf(languageOverview)).click();
                return new LanguagePage(driver);
            case certificates:
                scroll().waitUntils();
                wait.until(ExpectedConditions.visibilityOf(certificatesOverview)).click();
                return new CertificatesPage(driver);
            case projects:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(projectsOverview)).click();
                return new ProjectsPage(driver);
            case hobbies:
                scroll().waitUntils();
                wait.until(ExpectedConditions.visibilityOf(hobbiesOverview)).click();
                return new HobbiesPage(driver);
            case socialLinks:
                wait.until(ExpectedConditions.elementToBeClickable(socialNetworkLinksOverview)).click();
                return new SocialLinksPage(driver);
            case click:
                wait.until(ExpectedConditions.elementToBeClickable(clickToSeeOverview)).click();
                return new OverviewPage(driver);
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
