package pages;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.LinksEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.landingpage.WaitFooterElement;
import pages.linkspages.*;

public class LinksPage extends TalentbasePage {

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
    private WaitFooterElement navigateFooterLinksPage(){
        return new WaitFooterElement(driver);
    }
    @Step("Click Talentbase mini menu icon links in footer.")
    public TalentbasePage clickFooterElements(LinksEnum element) {
        switch (element) {
            case linkedIn:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(linkedInFooterMenuIcon).click().perform();
                return new LinkedInPage(driver);
            case facebook:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(facebookFooterMenuIcon).click().perform();
                return new FacebookPage(driver);
            case twitter:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(twitterFooterMenuIcon).click().perform();
                return new TwitterPage(driver);
            case mail:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(mailFooterMenuItem).click().perform();
                return new TwitterPage(driver);
        }
        return null;
    }
    @Step("Click Talentbase mini menu icon links.")
    public TalentbasePage clickBottomElements(LinksEnum element) {
        switch (element) {
            case linkedIn:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(linkedInFooterMenuIcon).click().perform();
                return new LinkedInPage(driver);
            case facebook:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(facebookFooterMenuIcon).click().perform();
                return new FacebookPage(driver);
            case twitter:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(twitterFooterMenuIcon).click().perform();
                return new TwitterPage(driver);
        }
        return null;
    }
}
