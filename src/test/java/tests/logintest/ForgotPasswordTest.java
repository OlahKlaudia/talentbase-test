package tests.logintest;

import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.headerlinks.SignInPage;
import pages.loginpage.ResetPasswordPage;
import tests.registrationtest.EmailVerifyTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForgotPasswordTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateForgotPasswordPage() {
        navigateToTalentbasePage();
        signInPage().navigateSignIn();
        signInPage().forgotPasswordLink().navigateForgotPasswordLink();
    }

    public SignInPage signInPage() {
        return new SignInPage(getDriver());
    }
    public ResetPasswordPage resetPasswordPage() {
        return new ResetPasswordPage(getDriver());
    }
    public EmailVerifyTest emailVerifyTest() {
        return new EmailVerifyTest();
    }

    @Test
    public void navigateForgotPasswordTest() {
        assertThat("Not found Forgot password link in the Talentbase site.", signInPage().forgotPasswordLink().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @Test
    public void invalidEmailTest() {
        signInPage().forgotPasswordLink().verifyInvalidEmail();
        assertThat("Not found invalid email error message.", signInPage().forgotPasswordLink().getEmailErrorMessage(), equalToIgnoringCase(INVALID_EMAIL_ERROR));
    }

    @Test
    public void validEmailTest() {
        signInPage().forgotPasswordLink().verifyValidEmail();
        assertTrue(signInPage().forgotPasswordLink().getPopUpButton().isDisplayed(), "Pop-up button is not visible");
    }

    @Test
    public void blankEmailTest() {
        signInPage().forgotPasswordLink().verifyBlankEmail();
        assertThat("Button is able.", signInPage().forgotPasswordLink().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @Test
    public void navigateResetPasswordTest() {
        navigateResetPasswordPage();
    }

    @Test
    public void createNewPasswordTest() {
        navigateResetPasswordPage();
        resetPasswordPage().createNewPassword();
    }

    public void navigateResetPasswordPage() { //todo wait until Reset password poge is visible
        signInPage().forgotPasswordLink().verifyValidEmail();
        assertTrue(signInPage().forgotPasswordLink().getPopUpButton().isDisplayed(), "Pop-up button is not visible");
        emailVerifyTest().loginGmail();
        signInPage().forgotPasswordLink().navigateCreatePassword();
        resetPasswordPage();
        assertThat("Wrong creditials.", getDriver().getCurrentUrl(), containsString(RESET_PASSWORD_PAGE));
    }
}
