package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import mainbase.mainenum.LinksEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LinksPage extends TalentbaseLandingPage {
    @FindBy(css = "a[href='https://www.linkedin.com/company/talentbasesavicsoft']")
    public WebElement linkedInMenuIcon;
    @FindBy(css = "a[href='https://www.facebook.com/TalentBase-102244162580303/']")
    public WebElement facebookMenuIcon;
    @FindBy(css = "a[href='https://twitter.com/TalentBase2022']")
    public WebElement twitterMenuIcon;
    @FindBy(css = "a[href='mailto:info@thetalentbase.com']")
    public WebElement mailMenuItem;

    @FindBy(css = ".MuiGrid-root:nth-child(2) a[href='https://www.linkedin.com/company/talentbasesavicsoft']")
    public WebElement linkedInFooterMenuIcon;
    @FindBy(css = ".MuiGrid-root:nth-child(2) a[href='https://www.facebook.com/TalentBase-102244162580303/']")
    public WebElement facebookFooterMenuIcon;
    @FindBy(css = ".MuiGrid-root:nth-child(2) a[href='https://twitter.com/TalentBase2022']")
    public WebElement twitterFooterMenuIcon;
    @FindBy(css = ".MuiGrid-root:nth-child(2) a[href='mailto:info@thetalentbase.com']")
    public WebElement mailFooterMenuItem;

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(TALENTBASE_URL);
    }

    @Step("Click Talentbase mini menu icon links in footer.")
    public String clickFooterElements(LinksEnum element) {
        switch (element) {
            case LINKED_IN:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(linkedInFooterMenuIcon));
                return linkedInFooterMenuIcon.getAttribute("href");
            case FACEBOOK:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(facebookFooterMenuIcon));
                return facebookFooterMenuIcon.getAttribute("href");
            case TWITTER:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(twitterFooterMenuIcon));
                return twitterFooterMenuIcon.getAttribute("href");
            case MAIL:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(mailFooterMenuItem));
                return mailFooterMenuItem.getAttribute("href");
        }
        return null;
    }

    @Step("Click Talentbase mini menu icon links.")
    public String clickAboutPageLinkElements(LinksEnum element) {
        switch (element) {
            case LINKED_IN:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(linkedInMenuIcon));
                return linkedInMenuIcon.getAttribute("href");
            case FACEBOOK:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(facebookMenuIcon));
                return facebookMenuIcon.getAttribute("href");
            case TWITTER:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(twitterMenuIcon));
                return twitterMenuIcon.getAttribute("href");
            case MAIL:
                logger.info(element.toString());
                navigateFooterLinksPage().scrollDown();
                wait.until(ExpectedConditions.elementToBeClickable(mailMenuItem));
                return mailMenuItem.getAttribute("href");
        }
        return null;
    }
}
