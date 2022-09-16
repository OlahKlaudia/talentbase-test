package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import mainbase.mainenum.FooterElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
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
    public void navigateTalentbasePage(){
        HomePage homePage=navigateToTalentbasePage();
        homePage.scrollDown().waitFooterVisibility();
    }
    public FooterSection footerSection(){
        return new FooterSection(getDriver());
    }
    @Test
    public void whyUsFooterLinkTest() {
     footerSection().clickFooterElements(FooterElementsEnum.whyUsLink);
        assertThat(getDriver().getCurrentUrl(), containsString(ABOUT_PAGE));
    }
    @Test
    public void blogFooterLinkTest() {
      footerSection().clickFooterElements(FooterElementsEnum.blog);
        assertThat("Not found Blog link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(BLOG_PAGE));
    }
    @Test
    public void partnersAndInvestorsLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.partnersAndInvestors);
        assertThat("Not found Partners And Investor link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(PARTNERS_AND_INVESTORS_PAGE));
    }
    @Test
    public void contactUsFooterLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.contactus);
        assertThat("Not found Contact Us link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(CONTACT_PAGE));
    }
    @Test
    public void lookingForWorkFooterLinkTest() {
       footerSection().clickFooterElements(FooterElementsEnum.lookingForWork);
        assertThat("Not found Looking For Work link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(LOOKING_FOR_WORK_PAGE));
    }
    @Test
    public void ourPolicyFooterLinkTest() {
        footerSection().clickFooterElements(FooterElementsEnum.ourPolicy);
        assertThat("Not found Our Policy link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(OUR_POLICY));
    }
    @Test
    public void websiteTermsFooterLinkTest() {
       footerSection().clickFooterElements(FooterElementsEnum.websiteTerms);
        assertThat("Not found Website Terms link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(WEBSITE_TERMS));
    }

}
