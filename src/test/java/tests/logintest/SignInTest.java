package tests.logintest;

import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.OverviewPage;
import pages.astalentleftpanel.StartPage;
import pages.headerlinks.SignInPage;
import pages.loginpage.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SignInTest extends TalentbaseTestBase {

    public LoginPage loginPage() {
        return new LoginPage(getDriver());
    }

    public OverviewPage overviewPage() {
        return new OverviewPage(getDriver());
    }

    public StartPage startPage() {
        return new StartPage(getDriver());
    }

    public SignInPage signInPage() {
        return new SignInPage(getDriver());
    }

    @BeforeEach
    public void navigateTalentbasePage() {
        navigateToTalentbasePage();
        signInPage().navigateSignIn();
    }

    @Test
    public void blankInputFieldTest() {
        signInPage().loginPage().verifyAllInputIsBlank();
        assertThat("Button is clickable.", signInPage().loginPage().getColor(), equalToIgnoringCase(COLOR_GREY));
        assertThat("Missing error message.", loginPage().getUsernameErrorMessage(), containsString(ERROR_MESSAGE));
        assertThat("Missing error message.", loginPage().getPasswordErrorMessage(), containsString(ERROR_MESSAGE));
    }

    @Test
    public void buttonDisableTest() {
        loginPage().verifyButtonIsDisable();
        assertThat("Button is able.", loginPage().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @Test
    public void shortPasswordTest() {
        loginPage().verifyInvalidPassword();
        assertThat("Missing short error message.", loginPage().getPasswordErrorMessage(), equalToIgnoringCase(SHORT_PASSWORD_ERROR));
    }

    @Test
    public void loginHireTalentTest() {
        loginPage().loginHireTalent();
        startPage().waitStartPageLoad();
        assertThat("Login failed.", getDriver().getCurrentUrl(), containsString(START_PAGE));
    }

    @Test
    public void signUpLinkTest() {
        loginPage().signUpLink();
        assertThat("Login failed.", getDriver().getCurrentUrl(), containsString(SIGN_UP));
    }

    @Test
    public void loginAsTalentTest() {
        loginPage().login();
        overviewPage();
        assertThat("Login failed.", getDriver().getCurrentUrl(), containsString(OVERVIEW));
    }
}

