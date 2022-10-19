package tests.logintest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.OverviewPage;
import pages.astalentleftpanel.StartPage;
import pages.headerlinks.SignInPage;
import pages.loginpage.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase login")
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
    public void beforeSignIn() {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.SIGN_IN);
    }

    @DisplayName("Blank Input Field on the Sign in Page Test")
    @Test
    public void blankInputFieldTest() {
        signInPage().loginPage().verifyAllInputIsBlank();
        assertThat("Button is clickable.", signInPage().loginPage().getColor(), equalToIgnoringCase(COLOR_GREY));
        assertThat("Missing error message.", loginPage().getUsernameErrorMessage(), containsString(ERROR_MESSAGE));
        assertThat("Missing error message.", loginPage().getPasswordErrorMessage(), containsString(ERROR_MESSAGE));
    }

    @DisplayName("Verify Button disable on the Sign in Page Test")
    @Test
    public void buttonDisableTest() {
        loginPage().verifyButtonIsDisable();
        assertThat("Button is able.", loginPage().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @DisplayName("Short Password on the Sign in Page Test")
    @Test
    public void shortPasswordTest() {
        loginPage().verifyInvalidPassword();
        assertThat("Missing short error message.", loginPage().getPasswordErrorMessage(), equalToIgnoringCase(SHORT_PASSWORD_ERROR));
    }

    @DisplayName("Login as Hire Talent Test")
    @Test
    public void loginHireTalentTest() {
        loginPage().loginHireTalent();
        startPage().waitStartPageLoad();
        assertThat("Login failed.", getDriver().getCurrentUrl(), containsString(START_PAGE));
    }

    @DisplayName("Sign up Link Test")
    @Test
    public void signUpLinkTest() {
        loginPage().signUpLink();
        assertThat("Login failed.", getDriver().getCurrentUrl(), containsString(SIGN_UP_PAGE));
    }

    @DisplayName("Login as Talent Test")
    @Test
    public void loginAsTalentTest() {
        loginPage().login();
        overviewPage();
        assertThat("Login failed.", getDriver().getCurrentUrl(), containsString(OVERVIEW_PAGE));
    }
}

