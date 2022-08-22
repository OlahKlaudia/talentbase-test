package pages.linkspages;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.loginpage.LoginPage;

public class SignInPage extends TalentbasePage {
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
    public ForgotPassword forgotPasswordLink(){
        return new ForgotPassword(driver);
    }
}
