package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import mainbase.mainenum.HeaderElementsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.headerlinks.*;

import java.time.Duration;

public class HeaderSection extends TalentbaseLandingPage {

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(blogItem));
    }

    @Step("Return header webelement,and assert header is visible.")
    public WebElement getHeaderIsVisible() {
        return header;
    }

    @Step("Click header menu item,return Page object.")
    public TalentbaseLandingPage clickHeaderElements(HeaderElementsEnum element) {
        switch (element) {
            case home:
                homeMenuItem.click();
                return new HomePage(driver);
            case talentbaseLogo:
                talentbaseLogoMenuItem.click();
                return new HomePage(driver);
            case partnersAndInvestors:
                partnersAndInvestorItem.click();
                return new PartnersAndInvestorsPage(driver);
            case lookingForWork:
                lookingForWorkItem.click();
                return new LookingForWorkPage(driver);
            case about:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(aboutItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(aboutItem)).click();
                return new AboutPage(driver);
            case contact:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(contactItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(contactItem)).click();
                return new ContactPage(driver);
            case salary:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(salaryItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(salaryItem)).click();
                return new SalaryPage(driver);
            case blog:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(blogItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(blogItem)).click();
                return new BlogPage(driver);
            case notification:
                notification.click();
                wait.until(ExpectedConditions.elementToBeClickable(showAllNotification)).click();
                return new NotificationPage(driver);
            case profile:
                profileItem.click();
                return new ProfilePage(driver);
            case base:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(baseItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(baseItem)).click();
                return new BasePage(driver);
            case signOut:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(signOut).perform();
                wait.until(ExpectedConditions.elementToBeClickable(signOut)).click();
                return new HomePage(driver);
            case applyAsTalent:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(applyAsTalentMenuItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(applyAsTalentMenuItem)).click();
                return new ApplyAsTalentPage(driver);
            case hireTalent:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(hireTalentMenuItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(hireTalentMenuItem)).click();
                return new HireTalentPage(driver);
            case signIn:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(loginMenuItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(loginMenuItem)).click();
                return new SignInPage(driver);
        }
        return null;
    }
}
