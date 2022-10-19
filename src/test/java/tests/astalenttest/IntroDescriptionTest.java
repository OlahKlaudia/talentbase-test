package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.IntroDescriptionPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class IntroDescriptionTest extends AsTalentTestBase {

    @BeforeEach
    public void beforeIntroDescription() {
        navigateAsTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.INTRO_DESCRIPTION);
    }

    public IntroDescriptionPage introDescriptionPage() {
        return new IntroDescriptionPage(getDriver());
    }

    @DisplayName("Valid input fields on the Intro Description Page Test")
    @Test
    public void introDescriptionTest() {
        introDescriptionPage().shortSummary();
        assertThat("Didn't get the summary error message text,and verify the user is not able to save with short summary.", introDescriptionPage().getColor(), equalToIgnoringCase(COLOR_RED));
    }
}
