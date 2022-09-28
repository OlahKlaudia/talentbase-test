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
    public void beforeHireTalent(){
        navigateHireSite();
    }
    public HeaderSection asTalentHeaderPage(){return new HeaderSection(getDriver());}

    @DisplayName("Header visibility Test")
    @Test
    public void headerVisibilityTest() {
        assertThat("Not found header on the Apply as Talent site.", asTalentHeaderPage().getHeaderIsVisible().isDisplayed());
    }

    @DisplayName("On the Hire Talent site the Talentbase logo Link Test")
    @Test
    public void talentbaseLogoLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.talentbaseLogo);
        assertThat("Not found Talentbase logo link on the Hire Talent site.",getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }

    @DisplayName("On the Hire Talent site the Partners and Investors Link Test")
    @Test
    public void partnersAndInvestorsLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.partnersAndInvestors);
        assertThat("Not found Partners And Investors link on the Hire Talent site.",getDriver().getCurrentUrl(), containsString(PARTNERS_AND_INVESTORS_PAGE));
    }
    @DisplayName("On the Hire Talent site the About us Link Test")
    @Test
    public void aboutLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.about);
        assertThat("Not found About link  on the Hire Talent site.",getDriver().getCurrentUrl(), containsString(ABOUT_PAGE));
    }
    @DisplayName("On the Hire Talent site the Contact us Link Test")
    @Test
    public void contactLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.contact);
        assertThat("Not found Contact link on the Hire Talent site.",getDriver().getCurrentUrl(), containsString(CONTACT_PAGE));
    }
    @DisplayName("On the Hire Talent site the Salary Link Test")
    @Test
    public void salaryLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.salary);
        assertThat("Not found Salary link on the Hire Talent site.",getDriver().getCurrentUrl(), containsString(SALARY));
    }
    @DisplayName("On the Hire Talent site the Blog Link Test")
    @Test
    public void blogLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.blog);
        assertThat("Not found Blog link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(BLOG_PAGE));
    }
    @DisplayName("On the Hire Talent site the Notification Link Test")
    @Test
    public void notificationLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.notification);
        assertThat("Not found Blog link on the Hire Talent site.", getDriver().getCurrentUrl(), containsString(NOTIFICATIONS_PAGE));
    }
    @DisplayName("On the Hire Talent site the Base Link Test")
    @Test
    public void baseLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.base);
        assertThat("Not found Base link on the Hire Talent site.",getDriver().getCurrentUrl(), containsString(BASE));
    }
    @DisplayName("On the Hire Talent site the Sign out Link Test")
    @Test
    public void signOutLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.signOut);
        assertThat("Not found Home link on the Hire Talent site.",getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }
}
