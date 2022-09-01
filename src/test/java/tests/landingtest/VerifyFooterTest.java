package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import mainbase.mainenum.FooterElementsEnum;
import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.Test;
import pages.linkspages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyFooterTest extends TalentbaseTestBase {

//    @DisplayName("Footer links functionality Test")
//    @Test
//    public void footerLinksFunctionalityTest() {
//        navigateToTalentbasePage();
//        WaitFooterElement navigate=new WaitFooterElement(getDriver());
//        navigate.waitFooterVisibility();
//        FooterSection footerFunctionality = new FooterSection(getDriver());
//
//        for (FooterElementsEnum footerElementsEnum : FooterElementsEnum.values()){
//            assertTrue( footerFunctionality.getFooterElements(footerElementsEnum).isDisplayed(), "Not found links in the Talentbase site");
//        }
//    }
    @BeforeEach
    public void navigateTalentbasePage(){
        navigateToTalentbasePage();
        homePage().scrollDown().waitFooterVisibility();
    }
    public HomePage homePage(){return new HomePage(getDriver());}
    @Test
    public void whyUsFooterLinkTest() {
        homePage().footerSection().clickFooterElements(FooterElementsEnum.whyUsLink);
        assertThat(getDriver().getCurrentUrl(), containsString(ABOUT_PAGE));
    }
    @Test
    public void blogFooterLinkTest() {
        homePage().footerSection().clickFooterElements(FooterElementsEnum.blog);
        assertThat("Not found Blog link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(BLOG_PAGE));
    }
    @Test
    public void partnersAndInvestorsLinkTest() {
        homePage().footerSection().clickFooterElements(FooterElementsEnum.partnersAndInvestors);
        assertThat("Not found Partners And Investor link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(PARTNERS_AND_INVESTORS_PAGE));
    }
    @Test
    public void contactUsFooterLinkTest() {
        homePage().footerSection().clickFooterElements(FooterElementsEnum.contactus);
        assertThat("Not found Contact Us link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(CONTACT_PAGE));
    }
    @Test
    public void lookingForWorkFooterLinkTest() {
        homePage().footerSection().clickFooterElements(FooterElementsEnum.lookingForWork);
        assertThat("Not found Looking For Work link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(LOOKING_FOR_WORK_PAGE));
    }
    @Test
    public void ourPolicyFooterLinkTest() {
        homePage().footerSection().clickFooterElements(FooterElementsEnum.ourPolicy);
        assertThat("Not found Our Policy link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(OUR_POLICY));
    }
    @Test
    public void websiteTermsFooterLinkTest() {
        homePage().footerSection().clickFooterElements(FooterElementsEnum.websiteTerms);
        assertThat("Not found Website Terms link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(WEBSITE_TERMS));
    }

}
