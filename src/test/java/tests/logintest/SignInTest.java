package tests.logintest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.OverviewPage;
import pages.leftpanellinkpage.StartPage;
import pages.linkspages.HomePage;
import pages.loginpage.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SignInTest extends TalentbaseTestBase {
    public HomePage homePage() {
        return new HomePage(getDriver());
    }
    public LoginPage loginPage() {
        return new LoginPage(getDriver());
    }
    public OverviewPage overviewPage() {
        return new OverviewPage(getDriver());
    }
    public StartPage startPage() {
        return new StartPage(getDriver());
    }
    @BeforeEach
    public void navigateTalentbasePage() {
        navigateToTalentbasePage();
        homePage().signInPage().navigateSignIn();
    }

    @Test
    public void blankInputFieldTest() {
        homePage().signInPage().loginPage().verifyAllInputIsBlank();
        assertThat("Button is clickable.",homePage().signInPage().loginPage().getColor(), equalToIgnoringCase(COLOR_GREY));
        assertThat("Missing error message.", loginPage().getUsernameErrorMessage(),containsString(ERROR_MESSAGE));
        assertThat("Missing error message.", loginPage().getPasswordErrorMessage(),containsString(ERROR_MESSAGE));
    }

    @Test
    public void buttonDisableTest() {
        loginPage().verifyButtonIsDisable();
        assertThat("Button is able.",loginPage().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @Test
    public void shortPasswordTest() {
        loginPage().verifyInvalidPassword();
        assertThat("Missing short error message.",loginPage().getPasswordErrorMessage(), equalToIgnoringCase(SHORT_PASSWORD_ERROR));
    }

    @Test
    public void loginHireTalentTest() {//todo assert start page
        loginPage().loginHireTalent();
        startPage();
//        assertThat("Login failed.",getDriver().getCurrentUrl(), containsString(START_PAGE));
    }

    @Test
    public void signUpLinkTest() {
        loginPage().signUpLink();
        assertThat("Login failed.",getDriver().getCurrentUrl(), containsString(SIGN_UP));
    }
    @Test
    public void loginAsTalentTest() {
        loginPage().login();
        overviewPage();
        assertThat("Login failed.",getDriver().getCurrentUrl(), containsString(OVERVIEW)); }
}

