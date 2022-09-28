package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.hiretalentpage.DownloadFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class OverviewTest extends AsTalentTestBase {
    @BeforeEach
    public void beforeOverview(){
        navigateAsTalentSite();
    }

    public DownloadFile downloadFile(){return new DownloadFile(getDriver());}

    @DisplayName("On the Overview Page Account details Link Test")
    @Test
    public void contractAdministratorOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.accountDetails);
        assertThat("Not found Account Details link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(ACCOUNT_DETAILS));
    }

    @DisplayName("On the Overview Page User Terms Link Test")
    @Test
    public void userTermsOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.userTerms);
        assertThat("Not found User Terms link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(USER_TERMS));
    }

    @DisplayName("On the Overview Page About me Link Test")
    @Test
    public void aboutMeOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.introDescription);
        assertThat("Not found User Terms link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(INTRO_DESCRIPTION));
    }

    @DisplayName("On the Overview Page Working Experience Link Test")
    @Test
    public void workingExperienceOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.experience);
        assertThat("Not found Working Experience link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(EXPERIENCE));
    }

    @DisplayName("On the Overview Page Education Link Test")
    @Test
    public void educationOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.education);
        assertThat("Not found Education link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(EDUCATION));
    }

    @DisplayName("On the Overview Page Certificates Link Test")
    @Test
    public void certificatesOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.certificates);
        assertThat("Not found Certificates link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(CERTIFICATES));
    }

    @DisplayName("On the Overview Page Project Link Test")
    @Test
    public void projectsOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.projects);
        assertThat("Not found Projects link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(PROJECT));
    }

    @DisplayName("On the Overview Page Location Link Test")
    @Test
    public void locationOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.evolution);
        assertThat("Not found Locations link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(ACCOUNT_DETAILS));
    }

    @DisplayName("On the Overview Page Social Link Test")
    @Test
    public void socialLinkOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.socialLinks);
        assertThat("Not found Social Link link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(SOCIAL_LINK));
    }

    @DisplayName("On the Overview Page Click to see Test")
    @Test
    public void clickToSeeOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.click);
        assertThat("Not found Social Link.",overviewPage().getSocialNetworkLink().isDisplayed());
    }

    @DisplayName("On the Overview Page Skills Link Test")
    @Test
    public void skillsOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.skills);
        assertThat("Not found Skills link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(SKILLS));
    }

    @DisplayName("On the Overview Page Language Link Test")
    @Test
    public void languageOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.language);
        assertThat("Not found Language link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(LANGUAGE));
    }

    @DisplayName("On the Overview Page Hobbies Link Test")
    @Test
    public void hobbiesOverviewTest() {
        overviewPage().clickOverviewElements(LeftPanelElementsEnum.hobbies);
        assertThat("Not found Hobbies link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(HOBBIES));
    }

    @DisplayName("On the Overview Page Salary hover Test")
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
