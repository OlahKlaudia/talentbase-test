package tests.registrationtest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.Test;
import pages.linkspages.HireTalentPage;
import pages.registrationpage.RegistrationHireTalentPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationHireTalentTest extends TalentbaseTestBase {

    public static final String COLOR_GREY = "rgba(189, 189, 189, 1)";
    public static final String SHORT_USERNAME_ERROR = "Username must be at least 6 characters.";
    public static final String LONG_USERNAME_ERROR = "Username must not exceed 50 characters in length.";
    public static final String INVALID_USERNAME_ERROR = "Username format invalid.";
    public static final String INVALID_EMAIL_ERROR = "Please enter a valid email address";

    @Test
    public void registrationAsHireTalent() {
        navigateToTalentbasePage();
        HireTalentPage navigateToHireTalent = new HireTalentPage(getDriver());
        navigateToHireTalent.navigateHireTalentPage();
        RegistrationHireTalentPage registrationHireTalent = new RegistrationHireTalentPage(getDriver());

        //ALL BLANK FIELDS
        registrationHireTalent.verifyUserIsAllBlank();
        assertThat(registrationHireTalent.getColor(), equalToIgnoringCase(COLOR_GREY));

        //checkbox selected and the button is disable
        registrationHireTalent.verifyCheckboxSelectedButtonDisable();
        assertThat(registrationHireTalent.getColor(), equalToIgnoringCase(COLOR_GREY));

        //USERNAME ERRORS
        registrationHireTalent.verifyShortUsername();
        assertThat(registrationHireTalent.getUsernameErrorMessage(), equalToIgnoringCase(SHORT_USERNAME_ERROR));

        registrationHireTalent.verifyLongUsername();
        assertThat(registrationHireTalent.getUsernameErrorMessage(), equalToIgnoringCase(LONG_USERNAME_ERROR));

        registrationHireTalent.verifyInvalidUsername();
        assertThat(registrationHireTalent.getUsernameErrorMessage(), equalToIgnoringCase(INVALID_USERNAME_ERROR));

        registrationHireTalent.verifyUsernameWithSpaces();
        assertThat(registrationHireTalent.getUsernameErrorMessage(), equalToIgnoringCase(INVALID_USERNAME_ERROR));

        //EMAIL ERRORS
        registrationHireTalent.verifyInvalidEmail();
        assertThat(registrationHireTalent.getEmailErrorMessage(),equalToIgnoringCase (INVALID_EMAIL_ERROR));
    }
}
