package tests.logintest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.Test;
import pages.linkspages.SignInPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ForgotPasswordTest extends TalentbaseTestBase {
    public static final String INVALID_EMAIL_ERROR = "Please enter a valid email address";

    @Test
    public void forgotPassword() {
        navigateToTalentbasePage();
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.navigateSignIn();

        signInPage.forgotPasswordLink().navigateForgotPasswordLink();
        assertThat(signInPage.forgotPasswordLink().getColor(), equalToIgnoringCase(COLOR_GREY));

        signInPage.forgotPasswordLink().verifyInvalidEmail();
        assertThat(signInPage.forgotPasswordLink().getEmailErrorMessage(), equalToIgnoringCase(INVALID_EMAIL_ERROR));

        signInPage.forgotPasswordLink().validEmail();
        assertThat(signInPage.forgotPasswordLink().getColor(), equalToIgnoringCase(BLACK));
    }
}
