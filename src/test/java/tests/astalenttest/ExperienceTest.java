package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.ExperiencePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class ExperienceTest extends AsTalentTestBase {

    @BeforeEach
    public void beforeExperience() throws InterruptedException {
        navigateAsTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.EXPERIENCE);
        experiencePage().addNew();
    }

    public ExperiencePage experiencePage() {
        return new ExperiencePage(getDriver());
    }

    @DisplayName("Long Title on the Experience Page Test")
    @Test
    public void longTitleTest() {
        experiencePage().verifyLongTitle();
        assertTrue(experiencePage().verifyLongTitle().contains(LONG_CHAR_ERROR), "Didn't get the title error message text,and verify the user is not able to save with long title.");
    }

    @DisplayName("Long location on the Experience Page Test")
    @Test
    public void longLocationTest() {
        experiencePage().verifyLongLocation();
        assertTrue(experiencePage().verifyLongLocation().contains(LONG_CHAR_ERROR), "Didn't get the location error message text,and verify the user is not able to save with long location.");
    }

    @DisplayName("Long company name on the Experience Page Test")
    @Test
    public void longCompanyNameTest() {
        experiencePage().verifyLongCompanyName();
        assertTrue(experiencePage().verifyLongCompanyName().contains(LONG_CHAR_ERROR), "Didn't get the company name error message text,and verify the user is not able to save with long company name.");
    }

    @DisplayName("Valid input fields on the Experience Page Test")
    @Test
    public void workingExperienceTest() {
        experiencePage().fillWorkingExperience();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.EXPERIENCE);
        experiencePage().delete();
    }

    @DisplayName("Blank fields on the Experience Page Test")
    @Test
    public void blankFieldWorkingExperienceTest() {
        experiencePage().blankFieldsWorkingExperience();
        assertThat("Button is able.", experiencePage().getColor(), equalToIgnoringCase(GREY));
    }

    @DisplayName("Verify checkbox on the Experience Page Test")
    @Test
    public void clickStillWorkHereCheckboxTest() {
        if (experiencePage().verifyCheckbox().contains(ORANGE)) {
            assertFalse(experiencePage().getEndDate().isEnabled(), "End date is disable");
        } else {
            experiencePage().verifyCheckbox();
            assertFalse(experiencePage().getEndDate().isEnabled(), "End date is disable");
        }
    }
}
