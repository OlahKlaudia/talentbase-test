package tests.astalenttest;

import mainbase.base.ProfileTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class OverviewTest extends ProfileTestBase {
    @BeforeEach
    public void navigateTalentbasePage(){
        HomePage homePage=navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginTest();
    }
    public SignInTest loginAsTalent(){return new SignInTest();}
    public OverviewPage overviewPage(){return new OverviewPage(getDriver());}

    @Test
    public void contractAdministratorOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.accountDetails);
        assertThat("Not found Account Details link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(ACCOUNT_DETAILS));
    }
    @Test
    public void userTermsOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.userTerms);
        assertThat("Not found User Terms link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(USER_TERMS));
    }
    @Test
    public void aboutMeOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.introDescription);
        assertThat("Not found User Terms link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(INTRO_DESCRIPTION));
    }
    @Test
    public void workingExperienceOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.experience);
        assertThat("Not found Working Experience link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(EXPERIENCE));
    }
    @Test
    public void educationOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.education);
        assertThat("Not found Education link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(EDUCATION));
    }
    @Test
    public void certificatesOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.certificates);
        assertThat("Not found Certificates link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(CERTIFICATES));
    }
    @Test
    public void projectsOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.projects);
        assertThat("Not found Projects link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(PROJECT));
    }
    @Test
    public void locationOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.evolution);
        assertThat("Not found Locations link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(ACCOUNT_DETAILS));
    }
    @Test
    public void socialLinkOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.socialLinks);
        assertThat("Not found Social Link link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(SOCIAL_LINK));
    }
    @Test
    public void skillsOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.skills);
        assertThat("Not found Skills link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(SKILLS));
    }
    @Test
    public void languageOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.language);
        assertThat("Not found Language link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(LANGUAGE));
    }
    @Test
    public void hobbiesOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.hobbies);
        assertThat("Not found Hobbies link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(HOBBIES));
    }

}
