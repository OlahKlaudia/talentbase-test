package tests.astalenttest;

import mainbase.base.ProfileTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentpage.LeftPanelLinksPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class LeftPanelTest extends ProfileTestBase {
    @BeforeEach
    public void navigateTalentbasePage(){
        HomePage homePage=navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginAsTalentTest();
    }
    public SignInTest loginAsTalent(){return new SignInTest();}
    public LeftPanelLinksPage leftPanelLinksPage(){return new LeftPanelLinksPage(getDriver());}
    @Test
    public void startLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.start);
        assertThat("Not found Start link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(START));
    }
    @Test
    public void overviewLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.overview);
        assertThat("Not found Overview link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(OVERVIEW));
    }
    @Test
    public void accountDetailsLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.accountDetails);
        assertThat("Not found Account Details link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(ACCOUNT_DETAILS));
    }
    @Test
    public void introDescriptionLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.introDescription);
        assertThat("Not found Intro Description link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(INTRO_DESCRIPTION));
    }
    @Test
    public void experienceLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.experience);
        assertThat("Not found Experience link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(EXPERIENCE));
    }
    @Test
    public void educationLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.education);
        assertThat("Not found Education link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(EDUCATION));
    }
    @Test
    public void skillsLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.skills);
        assertThat("Not found Skills link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(SKILLS));
    }
    @Test
    public void languageLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.language);
        assertThat("Not found Language link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(LANGUAGE));
    }
    @Test
    public void certificatesLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.certificates);
        assertThat("Not found Certificates link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(CERTIFICATES));
    }
    @Test
    public void projectLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.projects);
        assertThat("Not found Project link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(PROJECT));
    }
    @Test
    public void hobbiesLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.hobbies);
        assertThat("Not found Hobbies link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(HOBBIES));
    }
    @Test
    public void socialLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.socialLinks);
        assertThat("Not found Website Terms link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(SOCIAL_LINK));
    }
    @Test
    public void userTermsLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.userTerms);
        assertThat("Not found User Terms link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(USER_TERMS));
    }
    @Test
    public void evolutionLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.evolution);
        assertThat("Not found Experience link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(EVOLUTION));
    }

}
