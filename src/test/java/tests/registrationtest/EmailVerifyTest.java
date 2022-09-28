package tests.registrationtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.landingpage.EmailPage;
import pages.headerlinks.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase registration")
public class EmailVerifyTest extends TalentbaseTestBase {
    @BeforeEach
    public void beforeVerifyEmail() {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.applyAsTalent);
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
        assertThat("Wrong creditials.", getDriver().getCurrentUrl(), containsString(HOME_PAGE));
        //  error message is displayed
    }

    public void loginGmail(){
        assertThat("Wrong creditials.",emailPage().getAlertButton().isDisplayed());
        emailPage().navigateGmailSite();
        assertThat("Wrong creditials.",emailPage().getNextButton().isDisplayed());
        emailPage().typeEmailAddressToLoginGmail();
        assertThat("Wrong creditials.",emailPage().getNextButton().isDisplayed());
        emailPage().typePasswordToLoginGmail();
        assertThat("Wrong creditials.", getDriver().getCurrentUrl(), containsString(GMAIL));
        emailPage().verifyGetEmail();
        assertThat("Wrong creditials.",emailPage().getActivateLink().isDisplayed());
    }

}
