package pages.registrationpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebelementsPage extends TalentbasePage {
    @FindBy(css = "input[name='name']")
    public WebElement nameInput;
    @FindBy(css = "textarea[name='text']")
    public WebElement textarea;
    @FindBy(css = "button[type='submit']")
    public WebElement sendMessageButton;
    @FindBy(css = "input[name='username']")
    public WebElement usernameInput;

    @FindBy(css = "input[name='email']")
    public WebElement emailInput;

    @FindBy(css = "input[name='password']")
    public WebElement passwordInput;

    @FindBy(css = ".MuiFormControl-root:nth-child(1) .MuiSvgIcon-root")
    public WebElement checkboxSelect;
    @FindBy(css = "p:nth-child(1) a[href='/hire-talent']")
    public WebElement registerCorporation;

    @FindBy(css = "p:nth-child(1) a[href='/register']")
    public WebElement signUpAsTalentLink;

    @FindBy(css = "p:nth-child(1) a[href='/login']")
    public WebElement signInLink;

    @FindBy(css = "p:nth-child(2) a[href='/termsOfService']")
    public WebElement termsOfServiceLink;

    @FindBy(css = "p:nth-child(2) a[href='/privacyPolicy']")
    public WebElement privacyPolicyLink;

    @FindBy(css = "button[type='submit']")
    public WebElement registerCorporationButton;

    @FindBy(css = ".MuiFormHelperText-root")
    public WebElement usernameErrorMessage;

    @FindBy(css = ".MuiFormControl-root:nth-child(4) p")
    public WebElement emailErrorMessage;
    @FindBy(css = ".MuiFormControl-root:nth-child(6) p")
    public WebElement passwordErrorMessage;
    @FindBy(css = ".MuiFormControl-root:nth-child(4) p")
    public WebElement loginPasswordErrorMessage;

    @FindBy(css = ".MuiFormControl-root:nth-child(2) p")
    public WebElement forgotPasswordErrorMessage;
    @FindBy(css = ".MuiPaper-root .MuiButton-root")
    public WebElement popUpNextButton;

    public static final String SHORT_USERNAME = "test";
    public static final String LONG_USERNAME = "mSLsbjtFEnwbhVxZTJgNhq4pe7t6pnciex3XFSYOYWDAjXKRn5y";
    public static final String INVALID_USERNAME = "test12#";
    public static final String CONTAINS_SPACES_USERNAME = "test username";
    public static final String INVALID_EMAIL = "test+talentbase @digitalarcher.dev";
    public static final String USERNAME = "test123";
    public static final String EMAIL = "test+talentbase@digitalarcher.dev";
    public static final String PASSWORD = "password";
    public static final String WRONG_PASSWORD = "pass";
    public static final String LONG_PASSWORD = "4Zg9*A6Fk!p@SsUJconfirm4Zg9*A6Fk!p@SsUJconfirm4Zg9*A6Fk!p@SsUJconfirm";
    public static final String DELETE = Keys.chord(Keys.CONTROL, "a");
    public WebelementsPage(WebDriver driver) {
        super(driver);
    }
}
