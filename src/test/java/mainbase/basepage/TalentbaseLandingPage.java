package mainbase.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.landingpage.WaitFooterElement;

public class TalentbaseLandingPage extends BasePage {
    //header links
    @FindBy(css = ".navbar-stack a img")
    public WebElement talentbaseLogoMenuItem;

    @FindBy(css = ".navbar-stack a[href='/']")
    public WebElement homeMenuItem;

    @FindBy(css = ".navbar-stack a[href='/partners']")
    public WebElement partnersAndInvestorItem;

    @FindBy(css = ".navbar-stack a[href='/work']")
    public WebElement lookingForWorkItem;

    @FindBy(css = ".navbar-stack a[href='/about']")
    public WebElement aboutItem;

    @FindBy(css = ".navbar-stack a[href='/contact']")
    public WebElement contactItem;

    @FindBy(css = ".navbar-stack a[href='/calculator']")
    public WebElement salaryItem;

    @FindBy(css = ".navbar-stack a[href='/corp/base']")
    public WebElement baseItem;

    @FindBy(css = "a[href='/blog']")
    public WebElement blogItem;

    @FindBy(css = "a[href='/register']")
    public WebElement applyAsTalentMenuItem;

    @FindBy(css = "a[href='/hire-talent']:nth-child(2)")
    public WebElement hireTalentMenuItem;

    @FindBy(css = "a[href='/login']")
    public WebElement loginMenuItem;

    @FindBy(css = "span .clr-i-solid-path-1")
    public WebElement notification;
    @FindBy(css = ".MuiPaper-root .MuiMenuItem-gutters:nth-child(2) p")
    public WebElement showAllNotification;
    @FindBy(css = "#app-header")
    public WebElement header;

    @FindBy(css = ".navbar-stack a[href='/profile']")
    public WebElement profileItem;

    @FindBy(css = " a[href='/']:nth-child(3)")
    public WebElement signOut;

    //footer links

    public static final String TALENTBASE_URL = "https://dev.thetalentbase.com/";
    public TalentbaseLandingPage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {
    }
    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(TALENTBASE_URL);
    }
    public WaitFooterElement navigateFooterLinksPage(){
        return new WaitFooterElement(driver);
    }
}
