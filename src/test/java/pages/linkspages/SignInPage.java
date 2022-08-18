package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void navigateSignIn() {
        loginMenuItem.click();
    }
    public ForgotPassword forgotPasswordLink(){
        return new ForgotPassword(driver);
    }
}
