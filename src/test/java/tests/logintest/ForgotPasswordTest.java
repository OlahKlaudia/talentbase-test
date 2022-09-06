package tests.logintest;

import mainbase.base.TalentbaseTestBase;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.linkspages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForgotPasswordTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        navigateToTalentbasePage();
        homePage().signInPage().navigateSignIn();
        homePage().signInPage().forgotPasswordLink().navigateForgotPasswordLink();
    }

    public HomePage homePage() {
        return new HomePage(getDriver());
    }

    @Test
    public void navigateForgotPasswordTest() {
        assertThat("Not found Forgot password link in the Talentbase site.",homePage().signInPage().forgotPasswordLink().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @Test
    public void invalidEmailTest() {
        homePage().signInPage().forgotPasswordLink().verifyInvalidEmail();
        assertThat("Not found invalid email error message.",homePage().signInPage().forgotPasswordLink().getEmailErrorMessage(), equalToIgnoringCase(INVALID_EMAIL_ERROR));
    }

    @Test
    public void validEmailTest() {
        homePage().signInPage().forgotPasswordLink().validEmail();
        assertTrue(homePage().signInPage().forgotPasswordLink().getPopUpButton().isDisplayed(),"Pop-up button is not visible");
    }
    @Test
    public void blankEmailTest() {
        homePage().signInPage().forgotPasswordLink().emptyEmail();
        assertThat("Button is able.",homePage().signInPage().forgotPasswordLink().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

}
