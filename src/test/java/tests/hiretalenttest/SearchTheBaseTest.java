package tests.hiretalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.HireTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.hiretalentpage.DownloadFile;
import pages.hireleftpanel.MyBasePage;
import pages.hireleftpanel.SearchTheBasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase Hire Talent Site")
public class SearchTheBaseTest extends HireTestBase {
    public static final String GREEN = "rgba(0, 128, 0, 1)";
    public static final String BLACK = "rgba(0, 0, 0, 0)";
    public static final String RESULT_BLACK = "rgba(0, 0, 0, 1)";
    public static final String ORANGE = "rgba(241, 84, 18, 1)";

    @BeforeEach
    public void beforeHireTalent() {
        navigateHireSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.searchTheBase);
        searchTalent();

//        searchHireTalent().navigateTheBase();
    }

    public SearchTheBasePage searchTalent() {
        return new SearchTheBasePage(getDriver());
    }

    public DownloadFile downloadFile() {
        return new DownloadFile(getDriver());
    }

    public MyBasePage myBasePage() {
        return new MyBasePage(getDriver());
    }

    @DisplayName("Fill Valid data on the Search the base Page Test")
    @Test
    public void validSearchTheBaseTest() {
        searchTalent().validSearch();
        assertThat("There are no results for a search with a valid item", searchTalent().getNoResult().isDisplayed());
    }

    @DisplayName("Fill invalid data on the Search the base Page Test")
    @Test
    public void invalidSearchTheBaseTest() {
        searchTalent().invalidSearch();
        assertThat("A search with a valid element has a result.", searchTalent().getNoResult().isDisplayed());
    }

    @DisplayName("Result like element on the Search the base Page Test")
    @Test
    public void verifyResultLikeElementsTest() {
        if (searchTalent().getLikeColor().contains(GREEN)) {
            assertThat("The item was not clicked.", searchTalent().getLikeColor(), containsString(GREEN));

        } else {
            searchTalent().verifyResultLikeElement();
            assertThat("The item was not clicked.", searchTalent().getLikeColor(), containsString(GREEN));
        }
    }


    @DisplayName("Result export element and download pdf on the Search the base Page Test")
    @Test
    public void resultExportSearchTheBaseTest() throws Exception {
        if (searchTalent().getExportColor().contains(ORANGE)) {
            assertThat("The item was not clicked.", searchTalent().getExportColor(), containsString(ORANGE));

        } else {
            searchTalent().verifyResultExportElement();
            assertThat("The item was not clicked.", searchTalent().getExportColor(), containsString(ORANGE));
        }
        searchTalent().verifyDownloadExport();
        downloadFile().isFileDownloaded();
        downloadFile().getDownloadedFilesPath();
        downloadFile().isFileGreaterThanZero();

        assertThat("Downloaded file not found.", downloadFile().getDownloadedFilesPath(), containsString(".pdf"));
        downloadFile().cleanupDownloads();
    }

    @DisplayName("Back button element on the Search the base Page Test")
    @Test
    public void backButtonTest() {
        searchTalent().backButton();
        assertThat("Not found Hobbies link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(SEARCH_THE_BASE_PAGE));
    }

    @DisplayName("Verify hover visibility on the Search the base Page Test")
    @Test
    public void checkHoverTest() {
        searchTalent().verifyCheckmarks();
        assertThat("Not found checkmark hover.", searchTalent().verifyCheckmarks(), containsString("Grey checkmarks represent"));
    }

    @DisplayName("Verify salary hover visibility on the Search the base Page Test")
    @Test
    public void salaryHoverTest() {
        searchTalent().resultUserClick();
        searchTalent().verifyHoverSalary();
        assertThat("Not found Hobbies link in the Talentbase site.", searchTalent().verifyHoverSalary(), containsString("Salary shown is after tax and with our 15% fee."));
    }

    @DisplayName("Result bookmark element on the Search the base Page Test")
    @Test
    public void verifyResultBookmarkElementsTest() {
        if (searchTalent().getBookmarkColor().contains(RESULT_BLACK)) {
            assertThat("The item was not clicked.", searchTalent().getBookmarkColor(), containsString(RESULT_BLACK));

        } else {
            searchTalent().verifyResultBookmarkElement();
            assertThat("The item was not clicked.", searchTalent().getBookmarkColor(), containsString(RESULT_BLACK));
        }
    }

    @DisplayName("Verify bookmark element on the Talent Page Test")
    @Test
    public void bookmarkSearchTheBaseTest() {
        searchTalent().resultUserClick();

        if (searchTalent().getUserBookmarkColor().contains(BLACK)) {
            assertThat("The item was not clicked.", searchTalent().getUserBookmarkColor(), containsString(BLACK));
        } else {
            searchTalent().bookmarkAssertion();
            assertThat("The item was not clicked.", searchTalent().getUserBookmarkColor(), containsString(BLACK));
        }

        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.myBase);
//        myBasePage().navigateMyBasePage();
        myBasePage().checkFavorites();
        assertThat("Favorite Talent is not here.", myBasePage().getTalentFavorites().isDisplayed());
        myBasePage().countTalents();
    }

    @DisplayName("Navigate to Talent Page Test")
    @Test
    public void navigateTalentPageTest() {
        searchTalent().resultUserClick();
        if (searchTalent().getUserBookmarkColor().contains(BLACK)) {
            assertThat("The item was not clicked.", searchTalent().getUserBookmarkColor(), containsString(BLACK));
        } else {
            searchTalent().bookmarkAssertion();
            assertThat("The item was not clicked.", searchTalent().getUserBookmarkColor(), containsString(BLACK));
        }
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.myBase);
//        myBasePage().navigateMyBasePage();
        myBasePage().checkFavorites();
        myBasePage().navigateTalentPage();
        assertThat("Not the same.", getDriver().getCurrentUrl(), containsString("/user"));
    }

    @DisplayName("Hire button element on the Talent Page Test")
    @Test
    public void hireSearchTheBaseTest() {
        searchTalent().resultUserClick();
        searchTalent().hireTalentButton();
        assertThat("The item was not clicked.", searchTalent().getNextButton().isDisplayed());
        searchTalent().hireTalentAlertsClick();
    }

    @DisplayName("Contact button element on the Talent Page Test")
    @Test
    public void contactSearchTheBaseTest() {
        searchTalent().resultUserClick();
        searchTalent().contactTalent();
        assertThat("The item was not clicked.", searchTalent().getContactNextButton().isDisplayed());
        searchTalent().sendMessage();
    }

    @DisplayName("Search with lowercase on the Search the base Page Test")
    @Test
    public void lowercaseSearchTheBaseTest() {
        searchTalent().lowercaseSearch();
        assertThat("There are no results for a search with a valid item", searchTalent().getNoResult().isDisplayed());
    }
}
