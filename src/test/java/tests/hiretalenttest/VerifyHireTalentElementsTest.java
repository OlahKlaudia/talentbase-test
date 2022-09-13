package tests.hiretalenttest;

import mainbase.base.TalentbaseTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.hiretalentpage.LeftPanelLinkPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.AssertJUnit.assertFalse;

public class VerifyHireTalentElementsTest extends TalentbaseTestBase {

    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage=navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginHireTalentTest();
    }
    public SignInTest loginAsTalent() {
        return new SignInTest();
    }
    public LeftPanelLinkPage leftPanelLinksPage() {
        return new LeftPanelLinkPage(getDriver());
    }

    @Test
    public void startLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.start);
        assertThat("Not found Start link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(START_PAGE));
    }
    @Test
    public void accountLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.accountDetails);
        assertThat("Not found Account Details link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(ACCOUNT_PAGE));
    }
    @Test
    public void searchTheBaseLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.searchTheBase);
        leftPanelLinksPage();
        assertThat("Not found Search the base link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(SEARCH_THE_BASE_PAGE));
    }
    @Test
    public void myBaseLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.myBase);
        assertThat("Not found My base link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(MY_BASE_PAGE));
    }
    @Test
    public void closeLeftPanelTest() {
        leftPanelLinksPage().closeLeftPanel();
        assertFalse("Left panel it didn't close.",leftPanelLinksPage().getUsername().contains("KLAUDIA"));
    }
}
