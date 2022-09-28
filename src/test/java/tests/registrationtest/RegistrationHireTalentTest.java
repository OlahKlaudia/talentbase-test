package tests.registrationtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
import mainbase.mainenum.AsTalentLinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.headerlinks.HomePage;
import pages.registrationpage.RegistrationHireTalentPage;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase registration")
public class RegistrationHireTalentTest extends TalentbaseTestBase {
    @BeforeEach
    public void beforeRegistrationAsHire() {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.hireTalent);
    }


    public RegistrationHireTalentPage registration() {
        return new RegistrationHireTalentPage(getDriver());
    }

    @Test
    public void registrationAllBlankFieldsTest() {
        //ALL BLANK FIELDS
        registration().verifyUserIsAllBlank();
        assertThat(registration().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @Test
    public void checkboxSelectedButtonDisableTest() {
        //checkbox selected and the button is disable
        registration().verifyCheckboxSelectedButtonDisable();
        assertThat(registration().getColor(), equalToIgnoringCase(COLOR_GREY));
    }

    @Test
    public void shortUsernameTest() {
        //USERNAME ERRORS
        registration().verifyShortUsername();
        assertThat(registration().getUsernameErrorMessage(), equalToIgnoringCase(SHORT_USERNAME_ERROR));
    }

    @Test
    public void longUsernameTest() {
        registration().verifyLongUsername();
        assertThat(registration().getUsernameErrorMessage(), equalToIgnoringCase(LONG_USERNAME_ERROR));
    }

    @Test
    public void invalidUsernameTest() {
        registration().verifyInvalidUsername();
        assertThat(registration().getUsernameErrorMessage(), equalToIgnoringCase(INVALID_USERNAME_ERROR));
    }

    @Test
    public void usernameWithoutSpaceTest() {
        registration().verifyUsernameWithSpaces();
        assertThat(registration().getUsernameErrorMessage(), equalToIgnoringCase(INVALID_USERNAME_ERROR));
    }

    @Test
    public void invalidEmailTest() {
        //EMAIL ERRORS
        registration().verifyInvalidEmail();
        assertThat(registration().getEmailErrorMessage(), equalToIgnoringCase(INVALID_EMAIL_ERROR));
    }

    @Test
    public void shortPasswordTest() {
        //password
        registration().shortPassword();
        assertThat(registration().getPasswordErrorMessage(), equalToIgnoringCase(SHORT_PASSWORD_ERROR));
    }

    @Test
    public void longPasswordTest() {
        registration().longPassword();
        assertThat(registration().getPasswordErrorMessage(), equalToIgnoringCase(LONG_PASSWORD_ERROR));
    }

    @Test
    public void termsOfServiceLinkTest() {
        registration().verifyLinksFunctionality(AsTalentLinksEnum.termsOfService);
        assertThat("Not found Partners And Investor link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(WEBSITE_TERMS));
    }

    @Test
    public void privacyPolicyLinkTest() {
        registration().verifyLinksFunctionality(AsTalentLinksEnum.privacyPolicy);
        assertThat("Not found Our Policy link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(OUR_POLICY));
    }

    @Test
    public void registerCorporationLinkTest() {
        registration().verifyLinksFunctionality(AsTalentLinksEnum.registerCorporation);
        assertThat("Not found Register Corporation link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(SIGN_UP));
    }

    @Test
    public void signInLinkTest() {
        registration().verifyLinksFunctionality(AsTalentLinksEnum.signIn);
        assertThat("Not found Sign In link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(LOGIN));
    }
}
