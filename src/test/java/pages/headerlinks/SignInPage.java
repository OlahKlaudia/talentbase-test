package pages.headerlinks;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;
import pages.loginpage.ForgotPasswordPage;
import pages.loginpage.LoginPage;

public class SignInPage extends TalentbaseLandingPage {
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

    public ForgotPasswordPage forgotPasswordLink(){
        return new ForgotPasswordPage(driver);
    }
}
