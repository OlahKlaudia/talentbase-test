package tests.astalenttest;

import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.EducationPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class EducationTest extends AsTalentTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        navigateHireTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.education);
        educationPage().navigateEducationPage();
    }
    public EducationPage educationPage() {
        return new EducationPage(getDriver());
    }
    @Test
    public void educationTest() throws InterruptedException {
        educationPage().fillEducation();
        educationPage().waitButton();
    }
    @Test
    public void blankFieldEducationTest() {
       educationPage().blankFields();
        assertThat("Button is able.",educationPage().getColor(), equalToIgnoringCase(GREY));
    }
}
