package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.ProjectsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class ProjectsTest extends AsTalentTestBase {


    @BeforeEach
    public void beforeProject() throws InterruptedException {
        navigateAsTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.projects);
        projectsPage().addNew();
    }
    public ProjectsPage projectsPage() {
        return new ProjectsPage(getDriver());
    }

    @DisplayName("Type valid data on the Project Page Test")
    @Test
    public void projectsTest() throws InterruptedException {
        projectsPage().fillProjects();
        assertThat("Button is disable.", projectsPage().getColor(), containsString(ORANGE));
        projectsPage().waitButton();
        projectsPage().delete();
    }

    @DisplayName("Blank fields on the Project Page Test")
    @Test
    public void blankFieldsProjectTest() {
        projectsPage().blankFields();
        assertThat("Button is able.",projectsPage().getColor(), equalToIgnoringCase(GREY));
    }
}
