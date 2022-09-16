package tests.hiretalenttest;

import mainbase.testbase.HireTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.hiretalentpage.DownloadFile;
import pages.hireleftpanel.MyBasePage;
import pages.hireleftpanel.SearchTheBasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SearchTheBaseTest extends HireTestBase {
    public static final String GREEN = "rgba(0, 128, 0, 1)";
    public static final String BLACK = "rgba(0, 0, 0, 0)";
    public static final String RESULT_BLACK = "rgba(0, 0, 0, 1)";
    public static final String ORANGE = "rgba(241, 84, 18, 1)";

    @BeforeEach
    public void beforeHireTalent() {
        navigateHireSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.searchTheBase);
        searchHireTalent();

//        searchHireTalent().navigateTheBase();
    }

    public SearchTheBasePage searchHireTalent() {
        return new SearchTheBasePage(getDriver());
    }

    public DownloadFile downloadFile() {
        return new DownloadFile(getDriver());
    }

    public MyBasePage myBasePage() {
        return new MyBasePage(getDriver());
    }

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
    public void verifyResultLikeElementsTest() {
        if (searchHireTalent().getLikeColor().contains(GREEN)) {
            assertThat("The item was not clicked.", searchHireTalent().getLikeColor(), containsString(GREEN));

        } else {
            searchHireTalent().verifyResultLikeElement();
            assertThat("The item was not clicked.", searchHireTalent().getLikeColor(), containsString(GREEN));
        }
    }

    @Test
    public void verifyResultBookmarkElementsTest() {
        if (searchHireTalent().getBookmarkColor().contains(RESULT_BLACK)) {
            assertThat("The item was not clicked.", searchHireTalent().getBookmarkColor(), containsString(RESULT_BLACK));

        } else {
            searchHireTalent().verifyResultBookmarkElement();
            assertThat("The item was not clicked.", searchHireTalent().getBookmarkColor(), containsString(RESULT_BLACK));
        }
    }

    @Test
    public void resultExportSearchTheBaseTest() throws Exception {
        if (searchHireTalent().getExportColor().contains(ORANGE)) {
            assertThat("The item was not clicked.", searchHireTalent().getExportColor(), containsString(ORANGE));

        } else {
            searchHireTalent().verifyResultExportElement();
            assertThat("The item was not clicked.", searchHireTalent().getExportColor(), containsString(ORANGE));
        }
        searchHireTalent().verifyDownloadExport();
        downloadFile().isFileDownloaded();
        downloadFile().getDownloadedFilesPath();
        downloadFile().isFileGreaterThanZero();

        assertThat("Downloaded file not found.", downloadFile().getDownloadedFilesPath(), containsString(".pdf"));
        downloadFile().cleanupDownloads();
    }

    @Test
    public void backButtonTest() {
        searchHireTalent().backButton();
        assertThat("Not found Hobbies link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(SEARCH_THE_BASE_PAGE));
    }
    @Test
    public void checkHoverTest() {
        searchHireTalent().verifyCheckmarks();
        assertThat("Not found Hobbies link in the Talentbase site.", searchHireTalent().verifyCheckmarks(), containsString("Grey checkmarks represent"));
    }
    @Test
    public void salaryHoverTest() {
        searchHireTalent().resultUserClick();
        searchHireTalent().verifyHoverSalary();
        assertThat("Not found Hobbies link in the Talentbase site.", searchHireTalent().verifyHoverSalary(), containsString("Salary shown is after tax and with our 15% fee."));
    }
    @Test
    public void bookmarkSearchTheBaseTest() {
        searchHireTalent().resultUserClick();
        if (searchHireTalent().getUserBookmarkColor().contains(BLACK)) {
            assertThat("The item was not clicked.", searchHireTalent().getUserBookmarkColor(), containsString(BLACK));

        } else {
            searchHireTalent().bookmarkAssertion();
            assertThat("The item was not clicked.", searchHireTalent().getUserBookmarkColor(), containsString(BLACK));
        }
//        searchHireTalent().bookmarkAssertion();
//        assertThat("The item was not clicked.", searchHireTalent().getUserBookmarkColor(),containsString(BLACK));
//        searchHireTalent().bookmarkAssertion();
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

    @Test
    public void checkBookmarkTest() {
        searchHireTalent().resultUserClick();
        if (searchHireTalent().getUserBookmarkColor().contains(BLACK)) {
            assertThat("The item was not clicked.", searchHireTalent().getUserBookmarkColor(), containsString(BLACK));
        } else {
            searchHireTalent().bookmarkAssertion();
            assertThat("The item was not clicked.", searchHireTalent().getUserBookmarkColor(), containsString(BLACK));
        }
        myBasePage().navigateMyBasePage();
        myBasePage().checkFavorites();
        assertThat("Favorite Talent is not here.", myBasePage().getTalentFavorites().isDisplayed());
        myBasePage().countTalents();
    }

    @Test
    public void navigateTalentPageTest() {
        searchHireTalent().resultUserClick();
        if (searchHireTalent().getUserBookmarkColor().contains(BLACK)) {
            assertThat("The item was not clicked.", searchHireTalent().getUserBookmarkColor(), containsString(BLACK));
        } else {
            searchHireTalent().bookmarkAssertion();
            assertThat("The item was not clicked.", searchHireTalent().getUserBookmarkColor(), containsString(BLACK));
        }
        myBasePage().navigateMyBasePage();
        myBasePage().checkFavorites();
        myBasePage().navigateTalentPage();
        assertThat("Not the same.", getDriver().getCurrentUrl(), containsString("/user"));
    }
}
