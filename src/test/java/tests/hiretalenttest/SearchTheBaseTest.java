package tests.hiretalenttest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.SearchTheBasePage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SearchTheBaseTest extends TalentbaseTestBase {
    public static final String GREEN = "rgba(0, 128, 0, 1)";
    public static final String BLACK = "rgba(0, 0, 0, 1)";
    public static final String ORANGE = "rgb(168, 58, 12);";
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage=navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginHireTalentTest();
        searchHireTalent().navigateTheBase();
    }
    public SignInTest loginAsTalent() {
        return new SignInTest();
    }
    public SearchTheBasePage searchHireTalent() {
        return new SearchTheBasePage(getDriver());
    }
    @Test
    public void validSearchTheBaseTest() {
        searchHireTalent().validSearch();
        assertThat("Searching with Valid element no result.", searchHireTalent().getNoResult().isDisplayed());
    }
    @Test
    public void invalidSearchTheBaseTest() {
        searchHireTalent().invalidSearch();
        assertThat("Searching with invalid element,get result.", searchHireTalent().getNoResult().isDisplayed());
    }
    @Test
    public void resultSearchTheBaseTest() {
        searchHireTalent().result();
        assertThat("The item was not clicked.", searchHireTalent().getLikeColor(),containsString(GREEN));
        assertThat("The item was not clicked.", searchHireTalent().getBookmarkColor(),containsString(BLACK));
        assertThat("The item was not clicked.", searchHireTalent().getExportColor(),containsString(ORANGE));
    }
    @Test
    public void bookmarkSearchTheBaseTest() {
        searchHireTalent().bookmarkAssertion();
        assertThat("The item was not clicked.", searchHireTalent().getUserBookmarkColor(),containsString(BLACK));
    }
    @Test
    public void hireSearchTheBaseTest() {
        searchHireTalent().hireTalent();
        assertThat("The item was not clicked.", searchHireTalent().getNextButton().isDisplayed());
    }
    @Test
    public void contactSearchTheBaseTest() {
        searchHireTalent().contactTalent();
        assertThat("The item was not clicked.", searchHireTalent().getContactNextButton().isDisplayed());
    }

}
