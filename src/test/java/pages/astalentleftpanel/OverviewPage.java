package pages.astalentleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.astalentpage.WaitUntilLoadOverviewPage;

import java.util.List;

public class OverviewPage extends AsTalentBasePage { //todo rename
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
    @FindBy(css = ".MuiTooltip-popper")
    private WebElement salaryHover;
    @FindBy(css = ".MuiGrid-container:nth-child(4) a")
    private WebElement getSocialNetworkLink;


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

    @Step("Click export profile.")
    public void clickExportProfile() {
        logger.info("Click the Export Profile.");
        exportProfileAsPdf.click();
    }

    @Step("Wait until find the paragraph where contains /mo, and get salary hover text.")
    public String hoverSalary() {
        logger.info("Move to salary element, and the hover is appear.");
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        for (WebElement element : elements) {
            if (element.getText().contains("/mo")) {
                System.out.println("Paragraph text:" + element.getText());
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            }
        }
        action.moveToElement(salaryHover).click().perform();
        return salaryHover.getText();
    }

    @Step("Get social network link.")
    public WebElement getSocialNetworkLink() {
        logger.info("Get social network link.");
        return getSocialNetworkLink;
    }

    public WaitUntilLoadOverviewPage scroll() {
        return new WaitUntilLoadOverviewPage(driver);
    }

    @Step("Click Overview items, wait until the elements visible, and return Page Object.")
    public AsTalentBasePage clickOverviewElements(LeftPanelElementsEnum element) {
        switch (element) {
            case ACCOUNT_DETAILS:
                logger.info(element.toString());
                wait.until(ExpectedConditions.elementToBeClickable(contractAdministratorOverview)).click();
                return new AccountDetailsPage(driver);
            case INTRO_DESCRIPTION:
                logger.info(element.toString());
                wait.until(ExpectedConditions.elementToBeClickable(aboutMeOverview)).click();
                return new IntroDescriptionPage(driver);
            case EXPERIENCE:
                logger.info(element.toString());
                scroll().waitUntilScrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(workingExperienceOverview)).click();
                return new ExperiencePage(driver);
            case EDUCATION:
                logger.info(element.toString());
                scroll().waitUntilScrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(educationOverview)).click();
                return new EducationPage(driver);
            case SKILLS:
                logger.info(element.toString());
                wait.until(ExpectedConditions.elementToBeClickable(skillsOverview)).click();
                return new SkillsPage(driver);
            case LANGUAGE:
                logger.info(element.toString());
                scroll().waitUntilScrollDown();
                wait.until(ExpectedConditions.visibilityOf(languageOverview)).click();
                return new LanguagePage(driver);
            case CERTIFICATES:
                logger.info(element.toString());
                scroll().waitUntilScrollDown();
                wait.until(ExpectedConditions.visibilityOf(certificatesOverview)).click();
                return new CertificatesPage(driver);
            case PROJECTS:
                logger.info(element.toString());
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(projectsOverview)).click();
                return new ProjectsPage(driver);
            case HOBBIES:
                logger.info(element.toString());
                scroll().waitUntilScrollDown();
                wait.until(ExpectedConditions.visibilityOf(hobbiesOverview)).click();
                return new HobbiesPage(driver);
            case SOCIAL_LINKS:
                logger.info(element.toString());
                wait.until(ExpectedConditions.elementToBeClickable(socialNetworkLinksOverview)).click();
                return new SocialLinksPage(driver);
            case CLICK:
                logger.info(element.toString());
                wait.until(ExpectedConditions.elementToBeClickable(clickToSeeOverview)).click();
                return new OverviewPage(driver);
            case USER_TERMS:
                logger.info(element.toString());
                wait.until(ExpectedConditions.elementToBeClickable(userTermsOverview)).click();
                return new UserTermsPage(driver);
            case EVOLUTION:
                logger.info(element.toString());
                wait.until(ExpectedConditions.elementToBeClickable(locationOverview)).click();
                return new AccountDetailsPage(driver);
        }
        return null;
    }
}
