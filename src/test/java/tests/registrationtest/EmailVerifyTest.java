package tests.registrationtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.landingpage.EmailPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase registration")
public class EmailVerifyTest extends TalentbaseTestBase {
    @BeforeEach
    public void beforeVerifyEmail() {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.APPLY_AS_TALENT);
        reg().registrationTest();
    }

    public EmailPage emailPage() {
        return new EmailPage(getDriver());
    }

    public RegistrationApplyAsTalentTest reg() {
        return new RegistrationApplyAsTalentTest();
    }

    @DisplayName("Verify that received an email message Test")
    @Test
    public void verifyGetEmailTest() {
        loginGmail();
    }

    @DisplayName("Verify the Activation button navigate to the Home page Test")
    @Test
    public void verifyTheButtonNavigateHomePageTest() {
        loginGmail();
        emailPage().clickActivateAccountLink();
        assertThat("Home page is not visible.", getDriver().getCurrentUrl(), containsString(HOME_PAGE));
        //  error message is displayed
    }

    public void loginGmail() {
        assertThat("Alert is not display.", emailPage().getAlertButton().isDisplayed());
        emailPage().navigateGmailSite();
        assertThat("Next button is not display.", emailPage().getNextButton().isDisplayed());
        emailPage().typeEmailAddressToLoginGmail();
        assertThat("Second next button is not display.", emailPage().getNextButton().isDisplayed());
        emailPage().typePasswordToLoginGmail();
        assertThat("The URL is not correct.", getDriver().getCurrentUrl(), containsString(GMAIL_URL));
        emailPage().verifyGetEmail();
        assertThat("Activate link is not display.", emailPage().getActivateLink().isDisplayed());
    }

}
