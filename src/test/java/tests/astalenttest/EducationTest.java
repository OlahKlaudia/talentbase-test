package tests.astalenttest;

import mainbase.base.ProfileTestBase;
import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.EducationPage;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class EducationTest extends ProfileTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginAsTalentTest();
        overviewPage();
        educationPage().navigateEducationPage();
    }

    public SignInTest loginAsTalent() {
        return new SignInTest();
    }

    public EducationPage educationPage() {
        return new EducationPage(getDriver());
    }

    public OverviewPage overviewPage() {
        return new OverviewPage(getDriver());
    }
    @Test
    public void educationTest() throws InterruptedException {
        educationPage().fillEducation();
        educationPage().waitButton();
    }
    @Test
    public void blankFieldEducationTest() {
       educationPage().blankFields();
        assertThat("Button is able.",educationPage().getColor(), equalToIgnoringCase(GREY));
    }
}
