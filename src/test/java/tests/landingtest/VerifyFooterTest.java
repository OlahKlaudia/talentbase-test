package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import mainbase.mainenum.FooterElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.headerlinks.HomePage;
import pages.landingpage.FooterSection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyFooterTest extends TalentbaseTestBase {
    //todo footer section instability
    @BeforeEach
    public void beforeVerifyFooterTest() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.scrollDown().scrollDown();
    }

    public FooterSection footerSection() {
        return new FooterSection(getDriver());
    }

    @DisplayName("Why us Footer Link Test")
    @Test
    public void whyUsFooterLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.WHY_US_LINK);
        assertThat("Not found Why us link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(ABOUT_PAGE));
    }

    @DisplayName("Blog Footer Link Test")
    @Test
    public void blogFooterLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.BLOG);
        assertThat("Not found Blog link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(BLOG_PAGE));
    }

    @DisplayName("Partners and Investors Link Test")
    @Test
    public void partnersAndInvestorsLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.PARTNERS_AND_INVESTORS);
        assertThat("Not found Partners And Investor link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(PARTNERS_AND_INVESTORS_PAGE));
    }

    @DisplayName("Contact us Footer Link Test")
    @Test
    public void contactUsFooterLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.CONTACT_US);
        assertThat("Not found Contact Us link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(CONTACT_PAGE));
    }

    @DisplayName("Looking for Work Footer Link Test")
    @Test
    public void lookingForWorkFooterLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.LOOKING_FOR_WORK);
        assertThat("Not found Looking For Work link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(LOOKING_FOR_WORK_PAGE));
    }

    @DisplayName("Our Policy Footer Link Test")
    @Test
    public void ourPolicyFooterLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.OUR_POLICY);
        assertThat("Not found Our Policy link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(OUR_POLICY_PAGE));
    }

    @DisplayName("Website Terms Footer Link Test")
    @Test
    public void websiteTermsFooterLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.WEBSITE_TERMS);
        assertThat("Not found Website Terms link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(WEBSITE_TERMS_PAGE));
    }

}
