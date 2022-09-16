package tests.hiretalenttest;

import mainbase.testbase.HireTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.hiretalentpage.LeftPanelLinkPage;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.testng.AssertJUnit.assertFalse;

public class VerifyHireTalentElementsTest extends HireTestBase {

    @BeforeEach
    public void beforeHireTalent() {
        navigateHireSite();
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
        leftPanelLinksPage().verifyStartIsVisible();
        leftPanelLinksPage().closeLeftPanel();
        assertThat("Left panel is not closed.", leftPanelLinksPage().verifyStartIsVisible()==null);
    }
}
