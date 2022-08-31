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
    @FindBy(css = "a[href='https://www.linkedin.com/company/talentbasesavicsoft']")
    public WebElement linkedInMenuIcon;
    @FindBy(css = "a[href='https://www.facebook.com/TalentBase-102244162580303/']")
    public WebElement facebookMenuIcon;
    @FindBy(css = "a[href='https://twitter.com/TalentBase2022']")
    public WebElement twitterMenuIcon;
    @FindBy(css = "a[href='mailto:info@thetalentbase.com']")
    public WebElement mailMenuItem;
    @FindBy(css = ".MuiSelect-select")
    public WebElement employmentType;
    @FindBy(css = "ul li[data-value=\"Full Time\"]")
    public WebElement selectFullTime;
    @FindBy(css = "ul li[data-value=\"Other\"]")
    public WebElement bachelor;
    @FindBy(css = ".MuiCheckbox-root")
    public WebElement checkBox;
    @FindBy(css = "button[type='submit']")
    public WebElement saveSubmit;
    @FindBy(css = "div[data-aos=\"fade-right\"] .iconify--akar-icons")
    public WebElement addPlus;
    @FindBy(css = ".MuiFormControl-root:nth-child(1) .MuiFormHelperText-root")
    public WebElement titleError;
    @FindBy(css = ".MuiGrid-root:nth-child(2) .MuiFormHelperText-root")
    public WebElement companyNameError;
    @FindBy(css = ".MuiOutlinedInput-root .MuiButtonBase-root")
    public WebElement startDate;
    @FindBy(css = ".MuiYearPicker-root .Mui-selected")
    public WebElement select2022;
    @FindBy(css = ".MuiMonthPicker-root .Mui-selected")
    public WebElement selectAug;
    @FindBy(css = ".MuiFormControl-root:nth-child(2)  p")//nem teljesen okés
    public WebElement locationError;
    public static final String TALENTBASE_URL = "https://dev.thetalentbase.com/";
    public static final String LONG_CHAR = "mSLsbjtFEnwbhVxZTJgNhq4pe7t6pnciex3XFSYOYWDAjXKRn5ymSLsbjtFEnwbhVxZTJgNhq4pe7t6pnciex3XFSYOYWDAjXKRn5y";
    public static final String VALID_INPUT = "Test";

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
