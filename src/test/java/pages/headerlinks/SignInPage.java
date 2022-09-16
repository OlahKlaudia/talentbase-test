package pages.headerlinks;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.loginpage.ForgotPasswordPage;
import pages.loginpage.LoginPage;

public class SignInPage extends TalentbaseLandingPage {
    @FindBy(css = "a[href='/login']")
    private WebElement loginMenuItem;
    private static final String SIGN_IN_PAGE = "/login";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(SIGN_IN_PAGE);
    }

    public SignInPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage loginPage(){return new LoginPage(driver);}

    @Step("Navigate to Sign in Page.")
    public void navigateSignIn() {
        loginMenuItem.click();
    }
    public ForgotPasswordPage forgotPasswordLink(){
        return new ForgotPasswordPage(driver);
    }
}
