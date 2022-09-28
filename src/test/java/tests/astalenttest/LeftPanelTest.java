package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentpage.LeftPanelTalentLinksPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class LeftPanelTest extends AsTalentTestBase {
    @BeforeEach
    public void beforeAsTalentSite(){
        navigateAsTalentSite();
    }
    public LeftPanelTalentLinksPage leftPanelLinksPage(){return new LeftPanelTalentLinksPage(getDriver());}
    @Test
    public void startLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.start);
        assertThat("Not found Start link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(START));
    }
    @Test
    public void overviewLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.overview);
        assertThat("Not found Overview link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(OVERVIEW));
    }
    @Test
    public void accountDetailsLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.accountDetails);
        assertThat("Not found Account Details link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(ACCOUNT_DETAILS));
    }
    @Test
    public void introDescriptionLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.introDescription);
        assertThat("Not found Intro Description link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(INTRO_DESCRIPTION));
    }
    @Test
    public void experienceLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.experience);
        assertThat("Not found Experience link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(EXPERIENCE));
    }
    @Test
    public void educationLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.education);
        assertThat("Not found Education link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(EDUCATION));
    }
    @Test
    public void skillsLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.skills);
        assertThat("Not found Skills link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(SKILLS));
    }
    @Test
    public void languageLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.language);
        assertThat("Not found Language link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(LANGUAGE));
    }
    @Test
    public void certificatesLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.certificates);
        assertThat("Not found Certificates link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(CERTIFICATES));
    }
    @Test
    public void projectLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.projects);
        assertThat("Not found Project link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(PROJECT));
    }
    @Test
    public void hobbiesLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.hobbies);
        assertThat("Not found Hobbies link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(HOBBIES));
    }
    @Test
    public void socialLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.socialLinks);
        assertThat("Not found Website Terms link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(SOCIAL_LINK));
    }
    @Test
    public void userTermsLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.userTerms);
        assertThat("Not found User Terms link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(USER_TERMS));
    }
    @Test
    public void evolutionLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.evolution);
        assertThat("Not found Experience link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(EVOLUTION));
    }
    @Test
    public void closeLeftPanelTest() {
        leftPanelLinksPage().verifyStartIsVisible();
        leftPanelLinksPage().closeLeftPanel();
        assertThat("Left panel is not closed.", leftPanelLinksPage().verifyStartIsVisible()==null);
    }
}
