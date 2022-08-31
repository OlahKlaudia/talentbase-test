package tests.astalenttest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.EducationPage;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

public class EducationTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginTest();
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
    public void educationTest() {
        educationPage().fillEducation();
    }
}
