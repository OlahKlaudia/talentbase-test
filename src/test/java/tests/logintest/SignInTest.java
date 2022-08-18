package tests.logintest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.Test;
import pages.loginpage.LoginPage;
import pages.linkspages.SignInPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SignInTest extends TalentbaseTestBase {

    public static final String SHORT_PASSWORD_ERROR = "Password must be at least 8 characters long.";
    @Test
    public void signInTest() {
        navigateToTalentbasePage();
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.navigateSignIn();

        LoginPage loginPage= new LoginPage(getDriver());
        loginPage.verifyAllInputIsBlank();
        assertThat(loginPage.getColor(), equalToIgnoringCase(COLOR_GREY));

        loginPage.verifyButtonIsDisable();
        assertThat(loginPage.getColor(), equalToIgnoringCase(COLOR_GREY));

        loginPage.verifyInvalidPassword();
        assertThat(loginPage.getPasswordErrorMessage(), equalToIgnoringCase(SHORT_PASSWORD_ERROR));

        loginPage.verifyValidCredentials();
        assertThat(loginPage.getColor(), equalToIgnoringCase(COLOR_GREY));

        loginPage.signUpLink();
        assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(HIRE_TALENT));
    }
}
