package tests.hiretalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.HireTestBase;
import mainbase.mainenum.HeaderElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.landingpage.HeaderSection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Epic("Talentbase")
@Feature("Talentbase Hire Talent Site")
public class AsHireHeaderTest extends HireTestBase {
    @BeforeEach
    public void beforeHireTalent() {
        navigateHireSite();
    }

    public HeaderSection asTalentHeaderPage() {
        return new HeaderSection(getDriver());
    }

    @DisplayName("Header visibility Test")
    @Test
    public void headerVisibilityTest() {
        assertThat("Not found header on the Apply as Talent site.", asTalentHeaderPage().getHeaderIsVisible().isDisplayed());
    }

    @DisplayName("On the Hire Talent site the Talentbase logo Link Test")
    @Test
    public void talentbaseLogoLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.TALENTBASE_LOGO);
        assertThat("Not found Talentbase logo link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }

    @DisplayName("On the Hire Talent site the Partners and Investors Link Test")
    @Test
    public void partnersAndInvestorsLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.PARTNERS_AND_INVESTORS);
        assertThat("Not found Partners And Investors link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(PARTNERS_AND_INVESTORS_PAGE));
    }

    @DisplayName("On the Hire Talent site the About us Link Test")
    @Test
    public void aboutLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.ABOUT);
        assertThat("Not found About link  on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(ABOUT_PAGE));
    }

    @DisplayName("On the Hire Talent site the Contact us Link Test")
    @Test
    public void contactLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.CONTACT);
        assertThat("Not found Contact link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(CONTACT_PAGE));
    }

    @DisplayName("On the Hire Talent site the Salary Link Test")
    @Test
    public void salaryLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.SALARY);
        assertThat("Not found Salary link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(SALARY_PAGE));
    }

    @DisplayName("On the Hire Talent site the Blog Link Test")
    @Test
    public void blogLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.BLOG);
        assertThat("Not found Blog link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(BLOG_PAGE));
    }

    @DisplayName("On the Hire Talent site the Notification Link Test")
    @Test
    public void notificationLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.NOTIFICATION);
        assertThat("Not found Blog link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(NOTIFICATIONS_PAGE));
    }

    @DisplayName("On the Hire Talent site the Base Link Test")
    @Test
    public void baseLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.BASE);
        assertThat("Not found Base link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(BASE_PAGE));
    }

    @DisplayName("On the Hire Talent site the Sign out Link Test")
    @Test
    public void signOutLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.SIGN_OUT);
        assertThat("Not found Home link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }
}
