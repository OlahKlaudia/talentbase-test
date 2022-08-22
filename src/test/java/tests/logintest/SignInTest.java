package tests.logintest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.linkspages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class SignInTest extends TalentbaseTestBase {
    public HomePage homePage() {
        return new HomePage(getDriver());
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
    }

    @Test
    public void buttondDisableTest() {
        homePage().signInPage().loginPage().verifyButtonIsDisable();
        assertThat(homePage().signInPage().loginPage().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @Test
    public void shortPasswordTest() {
        homePage().signInPage().loginPage().verifyInvalidPassword();
        assertThat(homePage().signInPage().loginPage().getPasswordErrorMessage(), equalToIgnoringCase(SHORT_PASSWORD_ERROR));
    }

    @Test
    public void validDataTest() {
        homePage().signInPage().loginPage().verifyValidCredentials();
        assertThat(homePage().signInPage().loginPage().getColor(), equalToIgnoringCase(COLOR_GREY));

        //  assertTrue(homePage().signInPage().loginPage().getPopUpButton().isDisplayed(),"Pop-up button is not visible." );
    }

    @Test
    public void signUpLinkTest() {
        homePage().signInPage().loginPage().signUpLink();
        assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(SIGN_UP));
    }
}

