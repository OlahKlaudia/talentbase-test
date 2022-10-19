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
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.START);
        assertThat("Not found Start link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(START));
    }
    @Test
    public void overviewLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.OVERVIEW);
        assertThat("Not found Overview link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(OVERVIEW_URL));
    }
    @Test
    public void accountDetailsLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.ACCOUNT_DETAILS);
        assertThat("Not found Account Details link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(ACCOUNT_DETAILS_URL));
    }
    @Test
    public void introDescriptionLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.INTRO_DESCRIPTION);
        assertThat("Not found Intro Description link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(INTRO_DESCRIPTION_URL));
    }
    @Test
    public void experienceLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.EXPERIENCE);
        assertThat("Not found Experience link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(EXPERIENCE_URL));
    }
    @Test
    public void educationLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.EDUCATION);
        assertThat("Not found Education link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(EDUCATION_URL));
    }
    @Test
    public void skillsLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.SKILLS);
        assertThat("Not found Skills link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(SKILLS_URL));
    }
    @Test
    public void languageLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.LANGUAGE);
        assertThat("Not found Language link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(LANGUAGE_URL));
    }
    @Test
    public void certificatesLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.CERTIFICATES);
        assertThat("Not found Certificates link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(CERTIFICATES_URL));
    }
    @Test
    public void projectLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.PROJECTS);
        assertThat("Not found Project link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(PROJECT_URL));
    }
    @Test
    public void hobbiesLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.HOBBIES);
        assertThat("Not found Hobbies link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(HOBBIES_URL));
    }
    @Test
    public void socialLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.SOCIAL_LINKS);
        assertThat("Not found Social Link link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(SOCIAL_LINK_URL));
    }
    @Test
    public void userTermsLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.USER_TERMS);
        assertThat("Not found User Terms link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(USER_TERMS_URL));
    }
    @Test
    public void evolutionLinkTest() {
        leftPanelLinksPage().clickLeftPanelElements(LeftPanelElementsEnum.EVOLUTION);
        assertThat("Not found Evolution link in the Hire as Talent site.", getDriver().getCurrentUrl(), containsString(EVOLUTION_URL));
    }
    @Test
    public void closeLeftPanelTest() {
        leftPanelLinksPage().verifyStartIsVisible();
        leftPanelLinksPage().closeLeftPanel();
        assertThat("Left panel is not closed.", leftPanelLinksPage().verifyStartIsVisible()==null);
    }
}
