package tests.registrationtest;

import mainbase.base.TalentbaseTestBase;
import mainbase.browserenum.FooterElementsEnum;
import org.junit.jupiter.api.Test;
import pages.linkspages.ApplyAsTalentPage;
import pages.registrationpage.RegistrationApplyAsTalentPage;
import pages.registrationpage.RegistrationHireTalentPage;
import pages.registrationpage.WaitLoadingPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class RegistrationApplyAsTalent extends TalentbaseTestBase {
    public static final String SHORT_USERNAME_ERROR = "Username must be at least 6 characters.";
    public static final String LONG_USERNAME_ERROR = "Username must not exceed 50 characters in length.";
    public static final String INVALID_USERNAME_ERROR = "Username format invalid.";
    public static final String INVALID_EMAIL_ERROR = "Please enter a valid email address";
    public static final String SHORT_PASSWORD_ERROR = "Password must be at least 8 characters long.";
    public static final String LONG_PASSWORD_ERROR = "Password can't be longer than 100 characters.";
    private static final String APPLY_AS_TALENT_PAGE = "https://dev.thetalentbase.com/register";

    @Test
    public void registrationAsHireTalent() {
        navigateToTalentbasePage();
        ApplyAsTalentPage navigateToHireTalent = new ApplyAsTalentPage(getDriver());
        navigateToHireTalent.navigateApplyTalentPage();
        RegistrationHireTalentPage registration = new RegistrationHireTalentPage(getDriver());

        //ALL BLANK FIELDS
        registration.verifyUserIsAllBlank();
        assertThat(registration.getColor(), equalToIgnoringCase(COLOR_GREY));

        //checkbox selected and the button is disable
        registration.verifyCheckboxSelectedButtonDisable();
        assertThat(registration.getColor(), equalToIgnoringCase(COLOR_GREY));

        //USERNAME ERRORS
        registration.verifyShortUsername();
        assertThat(registration.getUsernameErrorMessage(), equalToIgnoringCase(SHORT_USERNAME_ERROR));

        registration.verifyLongUsername();
        assertThat(registration.getUsernameErrorMessage(), equalToIgnoringCase(LONG_USERNAME_ERROR));

        registration.verifyInvalidUsername();
        assertThat(registration.getUsernameErrorMessage(), equalToIgnoringCase(INVALID_USERNAME_ERROR));

        registration.verifyUsernameWithSpaces();
        assertThat(registration.getUsernameErrorMessage(), equalToIgnoringCase(INVALID_USERNAME_ERROR));

        //EMAIL ERRORS
        registration.verifyInvalidEmail();
        assertThat(registration.getEmailErrorMessage(), equalToIgnoringCase(INVALID_EMAIL_ERROR));
        //password
        registration.shortPassword();
        assertThat(registration.getPasswordErrorMessage(), equalToIgnoringCase(SHORT_PASSWORD_ERROR));

        registration.longPassword();
//        assertThat(registrationHireTalent.getPasswordErrorMessage(),equalToIgnoringCase(LONG_PASSWORD_ERROR));
    }

    @Test
    public void linksInHireTalentTest() {
        navigateToTalentbasePage();
        ApplyAsTalentPage navigateToHireTalent = new ApplyAsTalentPage(getDriver());
        navigateToHireTalent.navigateApplyTalentPage();
        WaitLoadingPage waitLoadingPage = new WaitLoadingPage(getDriver());
        for (FooterElementsEnum footerElementsEnum : FooterElementsEnum.values()) {
            waitLoadingPage.waitButtonVisibility();
            RegistrationApplyAsTalentPage registration = new RegistrationApplyAsTalentPage(getDriver());
            registration.verifyLinksFunctionality(footerElementsEnum);
            getDriver().get(APPLY_AS_TALENT_PAGE);
        }
    }
}
