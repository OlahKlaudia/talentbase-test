package pages.leftpanellinkpage;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.astalentpage.waitUntil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @FindBy(css = "[data-aos=\"fade-right\"]:nth-child(3) .MuiLink-underlineAlways")
    private WebElement exportProfileAsPdf;
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


    private static final String SCREENSHOT_FOLDER = "." + File.separator + "target" + File.separator +"download" + File.separator ;
    public  boolean isFileDownloaded(String fileName,int iterations) throws Exception{
        boolean flag = false;
        File dir = new File(SCREENSHOT_FOLDER);


        for(int waitForDownload=0;waitForDownload<iterations;waitForDownload++){
            File[] dir_contents = dir.listFiles();
            for (int i = 0; i < dir_contents.length; i++) {
                if (dir_contents[i].getName().equals(fileName)){
                    System.out.println("File"+fileName+"has downloaded");
//                    Actions.log("[TestData]"+ IBrowser.downloadFolder+fileName+" exist.");
//                    File deleteFile= new File(IBrowser.downloadFolder+fileName);
//                    Actions.log("[TestData]"+IBrowser.downloadFolder+fileName+" deleted successfully.");
                    return flag=true;
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        return flag;
    }
    public  waitUntil scroll(){return new   waitUntil(driver);}
    @Step("Scroll down,wait footer visibility,return Page Object.")
    public TalentbasePage clickOverviewElements(LeftPanelElementsEnum element) {//todo scroll down and click the elements
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
//                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(workingExperienceOverview)).click();
                return new ExperiencePage(driver);
            case education:
                scroll().waitUntils();
//                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(educationOverview)).click();
                return new EducationPage(driver);
            case skills:
                wait.until(ExpectedConditions.elementToBeClickable(skillsOverview)).click();
                return new SkillsPage(driver);
            case language:
                scroll().waitUntils();
//                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(languageOverview)).click();
                return new LanguagePage(driver);
            case certificates:
                scroll().waitUntils();
//                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(certificatesOverview)).click();
                return new CertificatesPage(driver);
            case projects:
                scroll().waitUntils();
//                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(projectsOverview)).click();
                return new ProjectsPage(driver);
            case hobbies:
                scroll().waitUntils();
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
