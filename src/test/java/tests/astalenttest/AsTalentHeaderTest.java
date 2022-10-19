package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.HeaderElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.landingpage.HeaderSection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class AsTalentHeaderTest extends AsTalentTestBase {
    @BeforeEach
    public void beforeAsTalentSite() {
        navigateAsTalentSite();
    }

    public HeaderSection asTalentHeaderPage() {
        return new HeaderSection(getDriver());
    }

    @DisplayName("Header visibility Test")
    @Test
    public void headerVisibilityTest() {
        assertThat("Not found header on the Apply as Talent site.", asTalentHeaderPage().getHeaderIsVisible().isDisplayed());
    }

    @DisplayName("On the as Talent site the Talentbase logo Link Test")
    @Test
    public void talentbaseLogoLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.TALENTBASE_LOGO);
        assertThat("Not found Talentbase logo link on the Apply as Talent site.", getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }

    @DisplayName("On the as Talent site the Partners and Investors Link Test")
    @Test
    public void partnersAndInvestorsLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.PARTNERS_AND_INVESTORS);
        assertThat("Not found Partners And Investors link on the Apply as Talent site.", getDriver().getCurrentUrl(), containsString(PARTNERS_AND_INVESTORS_PAGE));
    }

    @DisplayName("On the as Talent site the Looking for Work Link Test")
    @Test
    public void lookingFotWorkLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.LOOKING_FOR_WORK);
        assertThat("Not found Looking for Work link on the Apply as Talent site.", getDriver().getCurrentUrl(), containsString(LOOKING_FOR_WORK_PAGE));
    }

    @DisplayName("On the as Talent site the About us Link Test")
    @Test
    public void aboutLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.ABOUT);
        assertThat("Not found About link  on the Apply as Talent site.", getDriver().getCurrentUrl(), containsString(ABOUT_PAGE));
    }

    @DisplayName("On the as Talent site the Contact us Link Test")
    @Test
    public void contactLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.CONTACT);
        assertThat("Not found Contact link on the Apply as Talent site", getDriver().getCurrentUrl(), containsString(CONTACT_PAGE));
    }

    @DisplayName("On the as Talent site the Salary Link Test")
    @Test
    public void salaryLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.SALARY);
        assertThat("Not found Salary link on the Apply as Talent site.", getDriver().getCurrentUrl(), containsString(SALARY_PAGE));
    }

    @DisplayName("On the as Talent site the Blog Link Test")
    @Test
    public void blogLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.BLOG);
        assertThat("Not found Blog link on the Apply as Talent site.", getDriver().getCurrentUrl(), containsString(BLOG_PAGE));
    }

    @DisplayName("On the as Talent site the Notification Link Test")
    @Test
    public void notificationLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.NOTIFICATION);
        assertThat("Not found Blog link on the Apply as Talent site.", getDriver().getCurrentUrl(), containsString(NOTIFICATIONS_PAGE));
    }

    @DisplayName("On the as Talent site the Profile Link Test")
    @Test
    public void profileLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.PROFILE);
        assertThat("Not found About link  on the Apply as Talent site.", getDriver().getCurrentUrl(), containsString(OVERVIEW_URL));
    }

    @DisplayName("On the as Talent site the Sign out Link Test")
    @Test
    public void signOutLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.SIGN_OUT);
        assertThat("Not found Sign out link on the Apply as Talent site", getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }
}
