package landingpage;

import mainbase.browserenum.ElementEnum;
import mainbase.utils.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FooterPage extends TalentbasePage {

    @FindBy(css = ".footer")
    private WebElement footer;

    @FindBy(css = ".footer  p:nth-child(2)")
    private WebElement descriptiontitle;

    @FindBy(css = ".footer  p:nth-child(3)")
    private WebElement description;

    @FindBy(css = ".footer  img")
    private WebElement talentbaselogo;

    @FindBy(css = ".footer .MuiTypography-inherit:nth-child(1) svg")
    private WebElement linkedinmenuicon;

    @FindBy(css = ".footer .MuiTypography-inherit:nth-child(2) svg")
    private WebElement facebookmenuicon;

    @FindBy(css = ".footer .MuiTypography-inherit:nth-child(3) svg")
    private WebElement twittermenuicon;

    @FindBy(css = ".footer .MuiTypography-inherit:nth-child(4) svg")
    private WebElement mailmenuicon;

    @FindBy(css = "footer .MuiGrid-root:nth-child(1) .MuiGrid-item:nth-child(2) a:nth-child(1) ")
    private WebElement designers;

    @FindBy(css = "footer .MuiGrid-root:nth-child(1) .MuiGrid-item:nth-child(2) a:nth-child(2) ")
    private WebElement developers;

    @FindBy(css = "footer .MuiGrid-root:nth-child(1) .MuiGrid-item:nth-child(2) a:nth-child(3)")
    private WebElement financialexperts;

    @FindBy(css = "footer .MuiGrid-root:nth-child(1) .MuiGrid-item:nth-child(3) a:nth-child(1)")
    private WebElement whyuslink;

    @FindBy(css = "footer .MuiGrid-root:nth-child(1) .MuiGrid-item:nth-child(3) a:nth-child(2)")
    private WebElement clients;

    @FindBy(css = "footer .MuiGrid-root:nth-child(1) .MuiGrid-item:nth-child(3) a:nth-child(3)")
    private WebElement partnersandinvestors;

    @FindBy(css = "footer .MuiGrid-root:nth-child(1) .MuiGrid-item:nth-child(4) a:nth-child(1)")
    private WebElement contactus;

    @FindBy(css = "footer .MuiGrid-root:nth-child(1) .MuiGrid-item:nth-child(4) a:nth-child(2)")
    private WebElement support;

    @FindBy(css = "footer .MuiGrid-root:nth-child(1) .MuiGrid-item:nth-child(4) a:nth-child(3)")
    private WebElement faq;

    @FindBy(css = "footer .MuiGrid-root:nth-child(2)  .MuiGrid-item:nth-child(3) a:nth-child(1)")
    private WebElement ourpolicy;

    @FindBy(css = "footer .MuiGrid-root:nth-child(2)  .MuiGrid-item:nth-child(3) a:nth-child(1)")
    private WebElement websiteterms;

    @FindBy(css = "button svg")
    private WebElement gototop;

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFooterContent(){
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        return footer;
    }

    public void footerItemsVisibility(){

    talentbaselogo.isDisplayed();
    description.isDisplayed();
    descriptiontitle.isDisplayed();
    designers.isDisplayed();
    developers.isDisplayed();
    financialexperts.isDisplayed();
    whyuslink.isDisplayed();
    clients.isDisplayed();
    partnersandinvestors.isDisplayed();
    contactus.isDisplayed();
    support.isDisplayed();
    faq.isDisplayed();
    linkedinmenuicon.isDisplayed();
    facebookmenuicon.isDisplayed();
    twittermenuicon.isDisplayed();
    mailmenuicon.isDisplayed();
    ourpolicy.isDisplayed();
    websiteterms.isDisplayed();

    }
    public WebElement getFooterElements(ElementEnum element){

        switch (element)
        {
            case designers:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(designers));
                designers.click();
                return designers;
            case developers:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(developers));
                developers.click();
                return  developers;
            case financialexperts:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(financialexperts));
                financialexperts.click();
                return financialexperts;
            case whyuslink:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(financialexperts));
                whyuslink.click();
                return whyuslink;
            case clients:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(financialexperts));
                clients.click();
                return clients;
            case partnersandinvestors:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(financialexperts));
                partnersandinvestors.click();
                return partnersandinvestors;
            case contactus:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(financialexperts));
                contactus.click();
                return contactus;
            case support:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(financialexperts));
                support.click();
                return support;
            case faq:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(financialexperts));
                faq.click();
                return  faq;
//            case linkedinmenuicon:
//                return linkedinmenuicon;
//            case facebookmenuicon:
//                return facebookmenuicon;
//            case twittermenuicon:
//                return twittermenuicon;
//            case mailmenuicon:
//                return mailmenuicon;
            case ourpolicy:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(financialexperts));
                ourpolicy.click();
                return ourpolicy;
            case websiteterms:
                action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
                wait.until(ExpectedConditions.visibilityOf(financialexperts));
                websiteterms.click();
                return websiteterms;
        }
        return null;
    }
}
