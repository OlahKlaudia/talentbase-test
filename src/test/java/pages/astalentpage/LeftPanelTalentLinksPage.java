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

    @Step("Verify username is visible.")
    public String verifyStartIsVisible() { //TODO username változhat
        logger.info("Verify username is visible.");
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        for (WebElement element : elements) {
            if (element.getText().contains("TEST321")) {
                System.out.println("Left panel is not closed");
            } else
                System.out.println("Left panel is closed, and return null.");
            return null;
        }
        return null;
    }


    @Step("Click left panel elements,and return Page Object.")
    public AsTalentBasePage clickLeftPanelElements(LeftPanelElementsEnum element) {
        switch (element) {
            case START:
                logger.info(element.toString());
                action.moveToElement(startLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(startLink)).click();
                return new StartPage(driver);
            case OVERVIEW:
                logger.info(element.toString());
                action.moveToElement(overviewLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(overviewLink)).click();
                return new OverviewPage(driver);
            case ACCOUNT_DETAILS:
                logger.info(element.toString());
                action.moveToElement(accountDetailsLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(accountDetailsLink)).click();
                return new AccountDetailsPage(driver);
            case INTRO_DESCRIPTION:
                logger.info(element.toString());
                action.moveToElement(introDescriptionLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(introDescriptionLink)).click();
                return new IntroDescriptionPage(driver);
            case EXPERIENCE:
                logger.info(element.toString());
                action.moveToElement(experienceLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(experienceLink)).click();
                return new ExperiencePage(driver);
            case EDUCATION:
                logger.info(element.toString());
                action.moveToElement(educationLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(educationLink)).click();
                return new EducationPage(driver);
            case SKILLS:
                logger.info(element.toString());
                action.moveToElement(skillsLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(skillsLink)).click();
                return new SkillsPage(driver);
            case LANGUAGE:
                logger.info(element.toString());
                action.moveToElement(languageLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(languageLink)).click();
                return new LanguagePage(driver);
            case CERTIFICATES:
                logger.info(element.toString());
                action.moveToElement(certificatesLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(certificatesLink)).click();
                return new CertificatesPage(driver);
            case PROJECTS:
                logger.info(element.toString());
                action.moveToElement(projectsLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(projectsLink)).click();
                return new ProjectsPage(driver);
            case HOBBIES:
                logger.info(element.toString());
                action.moveToElement(hobbiesLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(hobbiesLink)).click();
                return new HobbiesPage(driver);
            case SOCIAL_LINKS:
                logger.info(element.toString());
                action.sendKeys(Keys.PAGE_DOWN).perform();
//                action.moveToElement(socialLinksLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(socialLinksLink)).click();
                return new SocialLinksPage(driver);
            case USER_TERMS:
                logger.info(element.toString());
                action.sendKeys(Keys.PAGE_DOWN).perform();
//                action.moveToElement(userTermsLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(userTermsLink)).click();
                userTermsLink.click();
                return new UserTermsPage(driver);
            case EVOLUTION:
                logger.info(element.toString());
                action.sendKeys(Keys.PAGE_DOWN).perform();
//                action.moveToElement(evolutionLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(evolutionLink)).click();
                return new EvolutionPage(driver);
        }
        return null;
    }
}
