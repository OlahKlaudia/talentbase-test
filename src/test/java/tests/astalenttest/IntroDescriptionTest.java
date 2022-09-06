package tests.astalenttest;

import mainbase.base.ProfileTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.IntroDescriptionPage;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class IntroDescriptionTest extends ProfileTestBase {

    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginAsTalentTest();
        overviewPage();
        introDescriptionPage().navigateIntroDescription();
    }

    public SignInTest loginAsTalent() {
        return new SignInTest();
    }

    public IntroDescriptionPage introDescriptionPage() {
        return new IntroDescriptionPage(getDriver());
    }

    public OverviewPage overviewPage() {
        return new OverviewPage(getDriver());
    }

    @Test
    public void introDescriptionTest() {
        introDescriptionPage().shortSummary();
        assertThat("Not found error message link in the Intro Description page.", introDescriptionPage().getColor(), equalToIgnoringCase(COLOR_RED));
    }
}
