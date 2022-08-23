package pages.astalentpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.leftpanellinkpage.*;

public class LeftPanelLinksPage extends TalentbasePage {

    public LeftPanelLinksPage(WebDriver driver) {
        super(driver);
    }

    @Step("Scroll down,wait footer visibility,return Page Object.")
    public TalentbasePage clickLeftPanelElements(LeftPanelElementsEnum element) {
        switch (element) {
            case start:
                wait.until(ExpectedConditions.elementToBeClickable(startLink)).click();
                return new StartPage(driver);
            case overview:
                wait.until(ExpectedConditions.elementToBeClickable(overviewLink)).click();
                return new OverviewPage(driver);
            case accountDetails:
                wait.until(ExpectedConditions.elementToBeClickable(accountDetailsLink)).click();
                return new AccountDetailsPage(driver);
            case introDescription:
                wait.until(ExpectedConditions.elementToBeClickable(introDescriptionLink)).click();
                return new IntroDescriptionPage(driver);
            case experience:
                wait.until(ExpectedConditions.elementToBeClickable(experienceLink)).click();
                return new ExperiencePage(driver);
            case education:
                wait.until(ExpectedConditions.elementToBeClickable(educationLink)).click();
                return new EducationPage(driver);
            case skills:
                wait.until(ExpectedConditions.elementToBeClickable(skillsLink)).click();
                return new SkillsPage(driver);
            case language:
                wait.until(ExpectedConditions.elementToBeClickable(languageLink)).click();
                return new LanguagePage(driver);
            case certificates:
                wait.until(ExpectedConditions.elementToBeClickable(certificatesLink)).click();
                return new CertificatesPage(driver);
            case projects:
                wait.until(ExpectedConditions.elementToBeClickable(projectsLink)).click();
                return new ProjectsPage(driver);
            case hobbies:
                wait.until(ExpectedConditions.elementToBeClickable(hobbiesLink)).click();
                return new HobbiesPage(driver);
            case socialLinks:
                wait.until(ExpectedConditions.elementToBeClickable(socialLinksLink)).click();
                return new SocialLinksPage(driver);
            case userTerms:
                wait.until(ExpectedConditions.elementToBeClickable(userTermsLink)).click();
                return new UserTermsPage(driver);
            case evolution:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(evolutionLink)).click();
                return new EvolutionPage(driver);
        }
        return null;
    }
}
