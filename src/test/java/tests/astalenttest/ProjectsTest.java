package tests.astalenttest;

import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.ProjectsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ProjectsTest extends AsTalentTestBase {
    public static final String ORANGE = "rgba(241, 84, 18, 1)";

    @BeforeEach
    public void navigateTalentbasePage() {
        navigateHireTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.projects);
        projectsPage().navigateProject();
    }
    public ProjectsPage projectsPage() {
        return new ProjectsPage(getDriver());
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
