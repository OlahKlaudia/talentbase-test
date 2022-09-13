package tests.astalenttest;

import mainbase.base.ProfileTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.OverviewPage;
import pages.leftpanellinkpage.UserTermsPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class UserTermsTest extends ProfileTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginAsTalentTest();
        overviewPage();
        userTermsPage().navigateUserTerms();
    }

    public SignInTest loginAsTalent() {
        return new SignInTest();
    }

    public UserTermsPage userTermsPage() {
        return new UserTermsPage(getDriver());
    }

    public OverviewPage overviewPage() {
        return new OverviewPage(getDriver());
    }

    @Test
    public void userTermsTest() throws InterruptedException {
        userTermsPage().fillUserTerms();
        userTermsPage().waitButton();
    }
    @Test
    public void blankFieldUserTermsTest() {
        userTermsPage().blankFields();
        assertThat("Button is able.",userTermsPage().getColor(), equalToIgnoringCase(GREY));
    }
}
