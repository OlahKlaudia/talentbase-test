package tests.registrationtest;

import mainbase.testbase.TalentbaseTestBase;
import mainbase.mainenum.AsTalentLinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.headerlinks.HomePage;
import pages.registrationpage.RegistrationApplyAsTalentPage;
import pages.registrationpage.RegistrationHireTalentPage;
import pages.registrationpage.WaitLoadingPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class RegistrationApplyAsTalentTest extends TalentbaseTestBase {

    @BeforeEach
    public void navigateApplyAsTalentPage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.applyAsTalentPage().navigateApplyTalentPage();
        WaitLoadingPage waitLoadingPage = new WaitLoadingPage(getDriver());
        waitLoadingPage.waitButtonVisibility();
    }

    public RegistrationHireTalentPage registration() {
        return new RegistrationHireTalentPage(getDriver());
    }

    public RegistrationApplyAsTalentPage registrationAsTalent() {
        return new RegistrationApplyAsTalentPage(getDriver());
    }

    @Test
    public void registrationWithBlankFieldTest() {
        //ALL BLANK FIELDS
        registration().verifyUserIsAllBlank();
        assertThat(registration().getColor(), containsString(COLOR_GREY));
    }

    @Test
    public void selectCheckboxButtonDisableTest() {
        //checkbox selected and the button is disable
        registration().verifyCheckboxSelectedButtonDisable();
        assertThat(registration().getColor(), containsString(COLOR_GREY));
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
    public void registrationTest() {
        registration().registrationAsTalent();
    }

    @Test
    public void termsOfServiceLinkTest() {
        registrationAsTalent().verifyLinksFunctionality(AsTalentLinksEnum.termsOfService);
        assertThat("Not found Partners And Investor link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(WEBSITE_TERMS));
    }

    @Test
    public void privacyPolicyLinkTest() {
        registrationAsTalent().verifyLinksFunctionality(AsTalentLinksEnum.privacyPolicy);
        assertThat("Not found Our Policy link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(OUR_POLICY));
    }

    @Test
    public void registerCorporationLinkTest() {
        registrationAsTalent().verifyLinksFunctionality(AsTalentLinksEnum.registerCorporation);
        assertThat("Not found Register Corporation link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(HIRE_TALENT));
    }

    @Test
    public void signInLinkTest() {
        registrationAsTalent().verifyLinksFunctionality(AsTalentLinksEnum.signIn);
        assertThat("Not found Sign In link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(LOGIN));
    }
}
