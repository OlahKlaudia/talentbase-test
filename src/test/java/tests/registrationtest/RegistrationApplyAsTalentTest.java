package tests.registrationtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
import mainbase.mainenum.AsTalentLinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.registrationpage.RegistrationApplyAsTalentPage;
import pages.registrationpage.RegistrationHireTalentPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase registration")
public class RegistrationApplyAsTalentTest extends TalentbaseTestBase {

    @BeforeEach
    public void beforeRegistrationAsTalent() {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.APPLY_AS_TALENT);
    }

    public RegistrationHireTalentPage registration() {
        return new RegistrationHireTalentPage(getDriver());
    }

    public RegistrationApplyAsTalentPage registrationAsTalent() {
        return new RegistrationApplyAsTalentPage(getDriver());
    }

    @DisplayName("Registration as Talent with blank fields Test")
    @Test
    public void registrationWithBlankFieldsTest() {
        registration().verifyUserIsAllBlank();
        assertThat(registration().getColor(), containsString(COLOR_GREY));
    }

    @DisplayName("With selected Checkbox, the button is disable Test")
    @Test
    public void selectCheckboxButtonDisableTest() {
        registration().verifyCheckboxSelectedButtonDisable();
        assertThat(registration().getColor(), containsString(COLOR_GREY));
    }

    @DisplayName("Registration as Talent with short username Test")
    @Test
    public void shortUsernameTest() {
        //USERNAME ERRORS
        registration().verifyShortUsername();
        assertThat(registration().getUsernameErrorMessage(), equalToIgnoringCase(SHORT_USERNAME_ERROR));
    }

    @DisplayName("Registration as Talent with long username Test")
    @Test
    public void longUsernameTest() {
        registration().verifyLongUsername();
        assertThat(registration().getUsernameErrorMessage(), equalToIgnoringCase(LONG_USERNAME_ERROR));
    }

    @DisplayName("Registration as Talent with invalid username Test")
    @Test
    public void invalidUsernameTest() {
        registration().verifyInvalidUsername();
        assertThat(registration().getUsernameErrorMessage(), equalToIgnoringCase(INVALID_USERNAME_ERROR));
    }

    @DisplayName("Registration as Talent with username without space Test")
    @Test
    public void usernameWithoutSpaceTest() {
        registration().verifyUsernameWithSpaces();
        assertThat(registration().getUsernameErrorMessage(), equalToIgnoringCase(INVALID_USERNAME_ERROR));
    }

    @DisplayName("Registration as Talent with invalid email Test")
    @Test
    public void invalidEmailTest() {
        //EMAIL ERRORS
        registration().verifyInvalidEmail();
        assertThat(registration().getEmailErrorMessage(), equalToIgnoringCase(INVALID_EMAIL_ERROR));
    }

    @DisplayName("Registration as Talent with short password Test ")
    @Test
    public void shortPasswordTest() {
        //password
        registration().shortPassword();
        assertThat(registration().getPasswordErrorMessage(), equalToIgnoringCase(SHORT_PASSWORD_ERROR));
    }

    @DisplayName("Registration as Talent with long password Test")
    @Test
    public void longPasswordTest() {
        registration().longPassword();
        assertThat(registration().getPasswordErrorMessage(), equalToIgnoringCase(LONG_PASSWORD_ERROR));
    }

    @DisplayName("Registration as Talent Test")
    @Test
    public void registrationTest() {
        registration().registrationAsTalent();
    }

    @DisplayName("Terms of Service Link Test")
    @Test
    public void termsOfServiceLinkTest() {
        registrationAsTalent().verifyLinksFunctionality(AsTalentLinksEnum.TERMS_OF_SERVICE);
        assertThat("Not found Partners And Investor link on the Apply as talent site.", getDriver().getCurrentUrl(), containsString(WEBSITE_TERMS_PAGE));
    }

    @DisplayName("Privacy Policy Link Test")
    @Test
    public void privacyPolicyLinkTest() {
        registrationAsTalent().verifyLinksFunctionality(AsTalentLinksEnum.PRIVACY_POLICY);
        assertThat("Not found Our Policy link on the Apply as talent site.", getDriver().getCurrentUrl(), containsString(OUR_POLICY_PAGE));
    }

    @DisplayName("Register Corporation Link Test")
    @Test
    public void registerCorporationLinkTest() {
        registrationAsTalent().verifyLinksFunctionality(AsTalentLinksEnum.REGISTER_CORPORATION);
        assertThat("Not found Register Corporation link on the Apply as talent site.", getDriver().getCurrentUrl(), containsString(HIRE_TALENT_PAGE));
    }

    @DisplayName("Sign in Link Test")
    @Test
    public void signInLinkTest() {
        registrationAsTalent().verifyLinksFunctionality(AsTalentLinksEnum.SIGN_IN);
        assertThat("Not found Sign In link on the Apply as talent site.", getDriver().getCurrentUrl(), containsString(LOGIN_PAGE));
    }
}
