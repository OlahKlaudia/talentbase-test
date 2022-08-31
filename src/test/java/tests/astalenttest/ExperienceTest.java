package tests.astalenttest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.ExperiencePage;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExperienceTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginTest();
        overviewPage();
        experiencePage().navigateWorkingExperience();
    }

    public SignInTest loginAsTalent() {
        return new SignInTest();
    }

    public ExperiencePage experiencePage() {
        return new ExperiencePage(getDriver());
    }

    public OverviewPage overviewPage() {
        return new OverviewPage(getDriver());
    }
    @Test
    public void longTitleTest() {
        experiencePage().verifyLongTitle();
        assertTrue(experiencePage().getTitleErrorText().contains(LONG_CHAR_ERROR), "Not found error message under the Title input field.");
    }
    @Test
    public void longLocationTest() {
        experiencePage().verifyLongLocation();
        assertTrue(experiencePage().getLocationErrorText().contains(LONG_CHAR_ERROR), "Not found error message under the Location input field.");
    }
    @Test
    public void longCompanyNameTest() {
        experiencePage().verifyLongCompanyName();
        assertTrue(experiencePage().getCompanyErrorText().contains(LONG_CHAR_ERROR), "Not found error message under the Company Name input field.");
    }
    @Test
    public void workingExperienceTest() {
        experiencePage().fillWorkingExperience();
    }

}
