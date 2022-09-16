package tests.registrationtest;

import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.landingpage.EmailPage;
import pages.headerlinks.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EmailVerifyTest extends TalentbaseTestBase {
    @BeforeEach
    public void registerAsTalent() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.applyAsTalentPage().navigateApplyTalentPage();
        reg().registrationTest();
    }

    public EmailPage emailPage() {
        return new EmailPage(getDriver());
    }

    public RegistrationApplyAsTalentTest reg() {
        return new RegistrationApplyAsTalentTest();
    }

    @Test
    public void verifyGetEmailTest() {
        loginGmail();
    }
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
