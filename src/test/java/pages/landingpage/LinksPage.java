package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.LinksEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.landingpage.WaitFooterElement;
import pages.linkspages.*;

public class LinksPage extends TalentbasePage {


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
    public String clickFooterElements(LinksEnum element) {
        switch (element) {
            case linkedIn:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(linkedInFooterMenuIcon));
                return linkedInFooterMenuIcon.getAttribute("href");
            case facebook:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(facebookFooterMenuIcon));
                return facebookFooterMenuIcon.getAttribute("href");
            case twitter:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(twitterFooterMenuIcon));
                return twitterFooterMenuIcon.getAttribute("href");
            case mail:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(mailFooterMenuItem));
                return mailFooterMenuItem.getAttribute("href");
        }
        return null;
    }
    @Step("Click Talentbase mini menu icon links.")
    public String clickAboutPageLinkElements(LinksEnum element) {
        switch (element) {
            case linkedIn:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(linkedInMenuIcon));
                return linkedInMenuIcon.getAttribute("href");
            case facebook:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(facebookMenuIcon));
                return facebookMenuIcon.getAttribute("href");
            case twitter:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(twitterMenuIcon));
                return twitterMenuIcon.getAttribute("href");
            case mail:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.elementToBeClickable(mailMenuItem));
                return mailMenuItem.getAttribute("href");
        }
        return null;
    }
}
