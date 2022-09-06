package tests.hiretalenttest;

import mainbase.base.TalentbaseTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.StartPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LandingTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage=navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginHireTalentTest();
        startPage();
    }
    public SignInTest loginAsTalent() {
        return new SignInTest();
    }
    public StartPage startPage() {
        return new StartPage(getDriver());
    }
    @Test
    public void searchTheBasePictureLinkTest() {
        startPage().searchTheBasePicture();
        assertThat("Not found Start link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(SEARCH_THE_BASE_PAGE));
    }
    @Test
    public void searchTheBaseButtonLinkTest() {
        startPage().searchTheBaseButton();
        assertThat("Not found Start link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(SEARCH_THE_BASE_PAGE));
    }
    @Test
    public void accountDetailsPictureLinkTest() {
        startPage().accountDetailsPicture();
        assertThat("Not found Start link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(ACCOUNT_PAGE));
    }
    @Test
    public void accountDetailsButtonLinkTest() {
        startPage().accountDetailsButton();
        assertThat("Not found Start link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(ACCOUNT_PAGE));
    }
}
