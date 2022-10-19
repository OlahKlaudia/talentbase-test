package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.EducationPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class EducationTest extends AsTalentTestBase {
    @BeforeEach
    public void beforeEducation() throws InterruptedException {
        navigateAsTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.EDUCATION);
        educationPage().addNew();
    }

    public EducationPage educationPage() {
        return new EducationPage(getDriver());
    }

    @DisplayName("Valid input fields on the Education Page Test")
    @Test
    public void educationTest() throws InterruptedException {
        educationPage().fillEducation();
        educationPage().waitButton();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.EDUCATION);
        educationPage().delete();
    }

    @DisplayName("Blank fields on the Education Page Test")
    @Test
    public void blankFieldEducationTest() {
        educationPage().blankFields();
        assertThat("Button is able.", educationPage().getColor(), equalToIgnoringCase(GREY));
    }
}
