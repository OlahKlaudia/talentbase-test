package tests.hiretalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.HireTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.hiretalentpage.LeftPanelLinkPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase Hire Talent Site")
public class AsHireLeftElementsTest extends HireTestBase {

    @BeforeEach
    public void beforeHireTalent() {
        navigateHireSite();
    }

    public LeftPanelLinkPage leftPanelLinksPage() {
        return new LeftPanelLinkPage(getDriver());
    }

    @DisplayName("Start Link Test")
    @Test
    public void startLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.START);
        assertThat("Not found Start link in the Hire Talent site.", getDriver().getCurrentUrl(), containsString(START_PAGE));
    }

    @DisplayName("Account Link Test")
    @Test
    public void accountLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.ACCOUNT_DETAILS);
        assertThat("Not found Account Details link in the Hire Talent site.", getDriver().getCurrentUrl(), containsString(ACCOUNT_PAGE));
    }

    @DisplayName("Search the base Link Test")
    @Test
    public void searchTheBaseLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.SEARCH_THE_BASE);
        leftPanelLinksPage();
        assertThat("Not found Search the base link in the Hire Talent site.", getDriver().getCurrentUrl(), containsString(SEARCH_THE_BASE_PAGE));
    }

    @DisplayName("My base Link Test")
    @Test
    public void myBaseLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.MY_BASE);
        assertThat("Not found My base link in the Hire Talent site.", getDriver().getCurrentUrl(), containsString(MY_BASE_PAGE));
    }

    @DisplayName("Close Left panel Test")
    @Test
    public void closeLeftPanelTest() {
        leftPanelLinksPage().verifyStartIsVisible();
        leftPanelLinksPage().closeLeftPanel();
        assertThat("Left panel is not closed.", leftPanelLinksPage().verifyStartIsVisible() == null);
    }
}
