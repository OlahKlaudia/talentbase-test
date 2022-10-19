package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import mainbase.mainenum.HeaderElementsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.headerlinks.*;

import java.time.Duration;

public class LoginHeaderPage extends TalentbaseLandingPage {

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(blogItem));
    }

    public LoginHeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click header menu item,return webelement,and assert header elements are visible.")
    public TalentbaseLandingPage clickHeaderElements(HeaderElementsEnum element) {
        switch (element) {
            case HOME:
                logger.info(element.toString());
                homeMenuItem.click();
                return new HomePage(driver);
            case TALENTBASE_LOGO:
                logger.info(element.toString());
                talentbaseLogoMenuItem.click();
                return new HomePage(driver);
            case PARTNERS_AND_INVESTORS:
                logger.info(element.toString());
                partnersAndInvestorItem.click();
                return new PartnersAndInvestorsPage(driver);
            case LOOKING_FOR_WORK:
                logger.info(element.toString());
                lookingForWorkItem.click();
                return new LookingForWorkPage(driver);
            case ABOUT:
                logger.info(element.toString());
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(aboutItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(aboutItem)).click();
                return new AboutPage(driver);
            case CONTACT:
                logger.info(element.toString());
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(contactItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(contactItem)).click();
                return new ContactPage(driver);
            case SALARY:
                logger.info(element.toString());
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(salaryItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(salaryItem)).click();
                return new SalaryPage(driver);
            case BLOG:
                logger.info(element.toString());
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(blogItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(blogItem)).click();
                return new BlogPage(driver);
            case NOTIFICATION:
                logger.info(element.toString());
                notification.click();
                wait.until(ExpectedConditions.elementToBeClickable(showAllNotification)).click();
                return new NotificationPage(driver);
            case PROFILE:
                logger.info(element.toString());
                profileItem.click();
                return new ProfilePage(driver);
            case BASE:
                logger.info(element.toString());
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(baseItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(baseItem)).click();
                return new BasePage(driver);
            case SIGN_OUT:
                logger.info(element.toString());
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                action.moveToElement(signOut).perform();
                wait.until(ExpectedConditions.elementToBeClickable(signOut)).click();
                return new HomePage(driver);
        }
        return null;
    }
}
