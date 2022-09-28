package pages.astalentpage;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import mainbase.basepage.AsTalentLeftPanelBasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.astalentleftpanel.*;

import java.util.List;

public class LeftPanelTalentLinksPage extends AsTalentLeftPanelBasePage {

    public LeftPanelTalentLinksPage(WebDriver driver) {
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
    public String verifyStartIsVisible() { //TODO username változhat
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        for (WebElement element : elements) {
            if(element.getText().contains("TEST321")){
                System.out.println("Left panel is nooot closed" );
            }
            else
                System.out.println("Left panel is closed, and return null.");
            return null;
        }
        return null;
    }



    @Step("Click left panel elements,and return Page Object.")
    public AsTalentBasePage clickLeftPanelElements(LeftPanelElementsEnum element) {
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
//                action.moveToElement(socialLinksLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(socialLinksLink)).click();
                return new SocialLinksPage(driver);
            case userTerms:
                action.sendKeys(Keys.PAGE_DOWN).perform();
//                action.moveToElement(userTermsLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(userTermsLink)).click();
                userTermsLink.click();
                return new UserTermsPage(driver);
            case evolution:
                action.sendKeys(Keys.PAGE_DOWN).perform();
//                action.moveToElement(evolutionLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(evolutionLink)).click();
                return new EvolutionPage(driver);
        }
        return null;
    }
}
