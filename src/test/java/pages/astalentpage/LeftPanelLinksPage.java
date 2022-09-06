package pages.astalentpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.leftpanellinkpage.*;

import java.time.Duration;

public class LeftPanelLinksPage extends TalentbasePage {

    public LeftPanelLinksPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {

    }
    public static final String OVERVIEW = "/profile";
    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(OVERVIEW);
    }

    @Step("Click left panel elements,and return Page Object.")
    public TalentbasePage clickLeftPanelElements(LeftPanelElementsEnum element) {
        switch (element) {
            case start:
                action.moveToElement(startLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(startLink)).click();
                return new StartPage(driver);
            case overview:
                action.moveToElement(overviewLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(overviewLink)).click();
                return new OverviewPage(driver);
            case accountDetails:
                action.moveToElement(accountDetailsLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(accountDetailsLink)).click();
                return new AccountDetailsPage(driver);
            case introDescription:
                action.moveToElement(introDescriptionLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(introDescriptionLink)).click();
                return new IntroDescriptionPage(driver);
            case experience:
                action.moveToElement(experienceLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(experienceLink)).click();
                return new ExperiencePage(driver);
            case education:
                action.moveToElement(educationLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(educationLink)).click();
                return new EducationPage(driver);
            case skills:
                action.moveToElement(skillsLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(skillsLink)).click();
                return new SkillsPage(driver);
            case language:
                action.moveToElement(languageLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(languageLink)).click();
                return new LanguagePage(driver);
            case certificates:
                action.moveToElement(certificatesLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(certificatesLink)).click();
                return new CertificatesPage(driver);
            case projects:
                action.moveToElement(projectsLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(projectsLink)).click();
                return new ProjectsPage(driver);
            case hobbies:
                action.moveToElement(hobbiesLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(hobbiesLink)).click();
                return new HobbiesPage(driver);
            case socialLinks:
                action.sendKeys(Keys.PAGE_DOWN).perform();
                action.moveToElement(socialLinksLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(socialLinksLink)).click();
                return new SocialLinksPage(driver);
            case userTerms:
                action.sendKeys(Keys.PAGE_DOWN).perform();
                action.moveToElement(userTermsLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(userTermsLink)).click();
                return new UserTermsPage(driver);
            case evolution:
                action.sendKeys(Keys.PAGE_DOWN).perform();
                action.moveToElement(evolutionLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(evolutionLink)).click();
                return new EvolutionPage(driver);
        }
        return null;
    }
}
