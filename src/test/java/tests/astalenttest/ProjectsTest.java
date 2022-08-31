package tests.astalenttest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.OverviewPage;
import pages.leftpanellinkpage.ProjectsPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

public class ProjectsTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginTest();
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
    public void projectsTest() {
    projectsPage().fillProjects();
    }
}
