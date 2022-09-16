package tests.astalenttest;

import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.IntroDescriptionPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class IntroDescriptionTest extends AsTalentTestBase {

    @BeforeEach
    public void navigateTalentbasePage() {
        navigateHireTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.introDescription);
//        introDescriptionPage().navigateIntroDescription();
    }
    public IntroDescriptionPage introDescriptionPage() {
        return new IntroDescriptionPage(getDriver());
    }

    @Test
    public void introDescriptionTest() {
        introDescriptionPage().shortSummary();
        assertThat("Not found error message link in the Intro Description page.", introDescriptionPage().getColor(), equalToIgnoringCase(COLOR_RED));
    }
}
