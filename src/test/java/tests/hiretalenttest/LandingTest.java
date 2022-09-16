package tests.hiretalenttest;

import mainbase.testbase.HireTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LandingTest extends HireTestBase {
    @BeforeEach
    public void beforeHireTalent() {
        navigateHireSite();
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
