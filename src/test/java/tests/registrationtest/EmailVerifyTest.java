package tests.registrationtest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.landingpage.EmailPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EmailVerifyTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.applyAsTalentPage().navigateApplyTalentPage();
        reg().registrationTest();
    }

    public SignInTest loginAsTalent() {
        return new SignInTest();
    }

    public EmailPage emailPage() {
        return new EmailPage(getDriver());
    }

    public RegistrationApplyAsTalentTest reg() {
        return new RegistrationApplyAsTalentTest();
    }

    @Test
    public void emailTest() {
        assertThat("Wrong creditials.",emailPage().getAlertButton().isDisplayed());
        emailPage().verifyEmail();
        assertThat("Wrong creditials.",emailPage().getNextButton().isDisplayed());
        emailPage().navigateLoginGmail();
        assertThat("Wrong creditials.",emailPage().getNextButton().isDisplayed());
        emailPage().password();
        assertThat("Wrong creditials.", getDriver().getCurrentUrl(), containsString(GMAIL));
        emailPage().lastEmail();
        assertThat("Wrong creditials.",emailPage().getActivateLink().isDisplayed());
        emailPage().activateButton();
        assertThat("Wrong creditials.", getDriver().getCurrentUrl(), containsString(HOME_PAGE));
        //todo  error message is displayed
    }
}
