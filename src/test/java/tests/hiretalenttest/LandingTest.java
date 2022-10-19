package tests.hiretalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.HireTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase Hire Talent Site")
public class LandingTest extends HireTestBase {
    @BeforeEach
    public void beforeHireTalent() {
        navigateHireSite();
    }

    @DisplayName("Search the base picture Link Test")
    @Test
    public void searchTheBasePictureLinkTest() {
        startPage().searchTheBasePicture();
        assertThat("Wrong url.",getDriver().getCurrentUrl(), containsString(SEARCH_THE_BASE_PAGE));
    }

    @DisplayName("Search the base button Link Test")
    @Test
    public void searchTheBaseButtonLinkTest() {
        startPage().searchTheBaseButton();
        assertThat("Wrong url.",getDriver().getCurrentUrl(), containsString(SEARCH_THE_BASE_PAGE));
    }

    @DisplayName("Account details picture Link Test")
    @Test
    public void accountDetailsPictureLinkTest() {
        startPage().accountDetailsPicture();
        assertThat("Wrong url.",getDriver().getCurrentUrl(), containsString(ACCOUNT_PAGE));
    }

    @DisplayName("Account details button Link Test")
    @Test
    public void accountDetailsButtonLinkTest() {
        startPage().accountDetailsButton();
        assertThat("Wrong url.",getDriver().getCurrentUrl(), containsString(ACCOUNT_PAGE));
    }
}
