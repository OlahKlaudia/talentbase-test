package tests.hiretalenttest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.hiretalentpage.DownloadFile;
import pages.leftpanellinkpage.SearchTheBasePage;
import pages.leftpanellinkpage.StartPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SearchTheBaseTest extends TalentbaseTestBase {
    public static final String GREEN = "rgba(0, 128, 0, 1)";
    public static final String BLACK = "rgba(0, 0, 0, 1)";
//    public static final String ORANGE = "rgba(233, 82, 17, 1)";
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage=navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginHireTalentTest();
        startPage();
        searchHireTalent().navigateTheBase();

    }
    public StartPage startPage() {
        return new StartPage(getDriver());
    }
    public SignInTest loginAsTalent() {
        return new SignInTest();
    }
    public SearchTheBasePage searchHireTalent() {
        return new SearchTheBasePage(getDriver());
    }
    public DownloadFile downloadFile(){return new DownloadFile(getDriver());}
    @Test
    public void validSearchTheBaseTest() {
        searchHireTalent().validSearch();
        assertThat("There are no results for a search with a valid item", searchHireTalent().getNoResult().isDisplayed());
    }
    @Test
    public void invalidSearchTheBaseTest() {
        searchHireTalent().invalidSearch();
        assertThat("A search with a valid element has a result.", searchHireTalent().getNoResult().isDisplayed());
    }
    @Test
    public void resultSearchTheBaseTest() throws Exception {
        searchHireTalent().verifyResultElements();

        assertThat("The item was not clicked.", searchHireTalent().getLikeColor(),containsString(GREEN));
        assertThat("The item was not clicked.", searchHireTalent().getBookmarkColor(),containsString(BLACK));

        searchHireTalent().verifyDownloadExport();
        searchHireTalent().verifyResultElements();

        downloadFile().isFileDownloaded();
        downloadFile().getDownloadedFilesPath();
        downloadFile().isFileGreaterThanZero();

        assertThat("Not found Hobbies link in the Talentbase site.",downloadFile().getDownloadedFilesPath(),containsString(".pdf"));
        downloadFile().cleanupDownloads();
    }
    @Test
    public void backButtonTest() {
        searchHireTalent().navigateTheBase();
        searchHireTalent().backButton();
        assertThat("Not found Hobbies link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(SEARCH_THE_BASE_PAGE));
    }
    @Test
    public void bookmarkSearchTheBaseTest() {
        searchHireTalent().resultUserClick();
        searchHireTalent().bookmarkAssertion();
        assertThat("The item was not clicked.", searchHireTalent().getUserBookmarkColor(),containsString(BLACK));
        searchHireTalent().bookmarkAssertion();
    }
    @Test
    public void hireSearchTheBaseTest() {
        searchHireTalent().resultUserClick();
        searchHireTalent().hireTalentButton();
        assertThat("The item was not clicked.", searchHireTalent().getNextButton().isDisplayed());
        searchHireTalent().hireTalentAlertsClick();
    }
    @Test
    public void contactSearchTheBaseTest() {
        searchHireTalent().resultUserClick();
        searchHireTalent().contactTalent();
        assertThat("The item was not clicked.", searchHireTalent().getContactNextButton().isDisplayed());
        searchHireTalent().sendMessage();
    }

    @Test
    public void lowercaseSearchTheBaseTest() {
        searchHireTalent().lowercaseSearch();
        assertThat("There are no results for a search with a valid item", searchHireTalent().getNoResult().isDisplayed());
    }

}
