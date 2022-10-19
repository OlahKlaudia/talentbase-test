package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import pages.landingpage.PageContentPage;
import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyPageContentTest extends TalentbaseTestBase {
    @BeforeEach
    public void beforeVerifyPage() {
        navigateToTalentbasePage();
    }

    public PageContentPage pageContent() {
        return new PageContentPage(getDriver());
    }

    @DisplayName("Page content functionality Test")
    @Test
    public void upperHireTalentButtonTest() {
        pageContent().navigateUpperHireTalentPage();
        assertThat("Not found Hire Talent page in the Talentbase site.", getDriver().getCurrentUrl(), containsString(HIRE_TALENT_PAGE));
    }

    @DisplayName("Why us Page content Link Test")
    @Test
    public void whyUsLinkTest() {
        pageContent().navigateWhyUsPage();
        assertThat("Not found Why us page in the Talentbase site.", getDriver().getCurrentUrl(), containsString(ABOUT_PAGE));

    }

    @DisplayName("Hire Talent Page content Link Test")
    @Test
    public void lowerHireTalentButtonTest() {
        pageContent().navigateLowerHireTalentPage();
        assertThat("Not found Hire Talent page in the Talentbase site", getDriver().getCurrentUrl(), containsString(HIRE_TALENT_PAGE));
    }

    @DisplayName("Scroll to Top button Test")
    @Test
    public void scrollToTopButtonTest() throws InterruptedException {
        pageContent().waitScrollToTopButton();
        assertThat("Not found Hire Talent page in the Talentbase site", pageContent().getHeader().isDisplayed());
    }
}
