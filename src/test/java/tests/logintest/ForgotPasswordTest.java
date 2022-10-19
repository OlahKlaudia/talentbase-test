package tests.logintest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.headerlinks.SignInPage;
import pages.loginpage.ResetPasswordPage;
import tests.registrationtest.EmailVerifyTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Talentbase")
@Feature("Talentbase login")
public class ForgotPasswordTest extends TalentbaseTestBase {
    @BeforeEach
    public void beforeForgotPassword() {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.SIGN_IN);
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

    @DisplayName("Navigate Forgot password Page Test")
    @Test
    public void navigateForgotPasswordTest() {
        assertThat("Not found Forgot password link in the Talentbase site.", signInPage().forgotPasswordLink().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @DisplayName("Invalid Forgot password email Test")
    @Test
    public void invalidEmailTest() {
        signInPage().forgotPasswordLink().verifyInvalidEmail();
        assertThat("Not found invalid email error message.", signInPage().forgotPasswordLink().getEmailErrorMessage(), equalToIgnoringCase(INVALID_EMAIL_ERROR));
    }

    @DisplayName("Valid Forgot password email Test")
    @Test
    public void validEmailTest() {
        signInPage().forgotPasswordLink().verifyValidEmail();
        assertTrue(signInPage().forgotPasswordLink().getPopUpButton().isDisplayed(), "Pop-up button is not visible");
    }

    @DisplayName("Blank forgot password email Test")
    @Test
    public void blankEmailTest() {
        signInPage().forgotPasswordLink().verifyBlankEmail();
        assertThat("Button is able.", signInPage().forgotPasswordLink().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    //todo headlessbe nem fut le
    @DisplayName("Navigate Reset password Test")
    @Test
    public void navigateResetPasswordTest() {
        navigateResetPasswordPage();
    }

    @DisplayName("Create new Password Test")
    @Test
    public void createNewPasswordTest() {
        navigateResetPasswordPage();
        resetPasswordPage().createNewPassword();
    }

    public void navigateResetPasswordPage() {
        signInPage().forgotPasswordLink().verifyValidEmail();
        assertTrue(signInPage().forgotPasswordLink().getPopUpButton().isDisplayed(), "Pop-up button is not visible");
        emailVerifyTest().loginGmail();
        signInPage().forgotPasswordLink().navigateCreatePassword();
        assertThat("Wrong creditials.", getDriver().getCurrentUrl(), containsString(RESET_PASSWORD_PAGE));
    }
}