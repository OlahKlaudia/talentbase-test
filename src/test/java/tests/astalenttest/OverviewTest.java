package tests.astalenttest;

import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.hiretalentpage.DownloadFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class OverviewTest extends AsTalentTestBase {
    @BeforeEach
    public void navigateTalentbasePage(){
        navigateHireTalentSite();
    }

    public DownloadFile downloadFile(){return new DownloadFile(getDriver());}

    @Test
    public void contractAdministratorOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.accountDetails);
        assertThat("Not found Account Details link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(ACCOUNT_DETAILS));
    }
    @Test
    public void userTermsOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.userTerms);
        assertThat("Not found User Terms link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(USER_TERMS));
    }
    @Test
    public void aboutMeOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.introDescription);
        assertThat("Not found User Terms link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(INTRO_DESCRIPTION));
    }
    @Test
    public void workingExperienceOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.experience);
        assertThat("Not found Working Experience link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(EXPERIENCE));
    }
    @Test
    public void educationOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.education);
        assertThat("Not found Education link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(EDUCATION));
    }
    @Test
    public void certificatesOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.certificates);
        assertThat("Not found Certificates link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(CERTIFICATES));
    }
    @Test
    public void projectsOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.projects);
        assertThat("Not found Projects link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(PROJECT));
    }
    @Test
    public void locationOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.evolution);
        assertThat("Not found Locations link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(ACCOUNT_DETAILS));
    }
    @Test
    public void socialLinkOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.socialLinks);
        assertThat("Not found Social Link link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(SOCIAL_LINK));
    }
    @Test
    public void clickToSeeOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.click);
        assertThat("Not found Social Link.",overviewPage().getSocialNetworkLink().isDisplayed());
    }
    @Test
    public void skillsOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.skills);
        assertThat("Not found Skills link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(SKILLS));
    }
    @Test
    public void languageOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.language);
        assertThat("Not found Language link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(LANGUAGE));
    }
    @Test
    public void hobbiesOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.hobbies);
        assertThat("Not found Hobbies link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(HOBBIES));
    }
    @Test
    public void hoverOverviewTest() {
        overviewPage().hoverSalary();
        assertThat("Not found hover when move to element above salary button.",overviewPage().hoverSalary(),containsString("The salary that is displayed is the one that you have set for yourself. You can change it in your profile."));
    }

    @Test
    public void downloadProfilePdfTest() throws Exception {
        overviewPage().clickExportProfile();

        downloadFile().isFileDownloaded();
        downloadFile().getDownloadedFilesPath();
        downloadFile().isFileGreaterThanZero();

        assertThat("Not found Hobbies link in the Talentbase site.",downloadFile().getDownloadedFilesPath(),containsString(".pdf"));
        downloadFile().cleanupDownloads();
    }
}
