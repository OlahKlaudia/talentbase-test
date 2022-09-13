package tests.astalenttest;

import mainbase.base.ProfileTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.OverviewPage;
import pages.leftpanellinkpage.ProjectsPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ProjectsTest extends ProfileTestBase {
    public static final String ORANGE = "rgba(241, 84, 18, 1)";

    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginAsTalentTest();
        overviewPage();
        projectsPage().navigateProject();
    }

    public SignInTest loginAsTalent() {
        return new SignInTest();
    }

    public ProjectsPage projectsPage() {
        return new ProjectsPage(getDriver());
    }

    public OverviewPage overviewPage() {
        return new OverviewPage(getDriver());
    }

    @Test
    public void projectsTest() throws InterruptedException {
        projectsPage().fillProjects();
        assertThat("Button is disable.", projectsPage().getColor(), containsString(ORANGE));
        projectsPage().waitButton();
    }
    @Test
    public void blankFieldProjectTest() {
        projectsPage().blankFields();
        assertThat("Button is able.",projectsPage().getColor(), equalToIgnoringCase(GREY));
    }
}
