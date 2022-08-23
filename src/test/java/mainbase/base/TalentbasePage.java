package mainbase.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TalentbasePage extends BasePage {
    @FindBy(css = "#app-header")
    public WebElement headerisvisible;

    @FindBy(css = ".navbar-stack a img")
    public WebElement talentbaselogomenuitem;

    @FindBy(css = ".navbar-stack a[href='/']")
    public WebElement homemenuitem;

    @FindBy(css = ".navbar-stack a[href='/partners']")
    public WebElement partnersandinvestoritem;

    @FindBy(css = ".navbar-stack a[href='/work']")
    public WebElement lookingforworkitem;

    @FindBy(css = ".navbar-stack a[href='/about']")
    public WebElement aboutitem;

    @FindBy(css = ".navbar-stack a[href='/contact']")
    public WebElement contactitem;

    @FindBy(css = ".navbar-stack a[href='/blog']")
    public WebElement blogitem;
    @FindBy(css = "a[href='/Profile/start']")
    public WebElement startLink;

    @FindBy(css = ".MuiBox-root a[href='/profile']")
    public WebElement overviewLink;

    @FindBy(css = ".MuiBox-root a[href='/profile/account']")
    public WebElement accountDetailsLink;

    @FindBy(css = "a[href='/profile/intro']")
    public WebElement introDescriptionLink;

    @FindBy(css = "a[href='/profile/experience']")
    public WebElement experienceLink;

    @FindBy(css = "a[href='/profile/education']")
    public WebElement educationLink;

    @FindBy(css = "a[href='/profile/skills']")
    public WebElement skillsLink;

    @FindBy(css = "a[href='/profile/languages']")
    public WebElement languageLink;

    @FindBy(css = "a[href='/profile/certificates']")
    public WebElement certificatesLink;

    @FindBy(css = "a[href='/profile/projects']")
    public WebElement projectsLink;

    @FindBy(css = "a[href='/profile/hobbies']")
    public WebElement hobbiesLink;

    @FindBy(css = "a[href='/profile/social']")
    public WebElement socialLinksLink;

    @FindBy(css = "a[href='/profile/terms']")
    public WebElement userTermsLink;

    @FindBy(css = "a[href='/profile/evaluation']")
    public WebElement evolutionLink;
    public static final String TALENTBASE_URL = "https://dev.thetalentbase.com/";


    public TalentbasePage(WebDriver driver) {
        super(driver);
    }
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(TALENTBASE_URL);
    }

}
