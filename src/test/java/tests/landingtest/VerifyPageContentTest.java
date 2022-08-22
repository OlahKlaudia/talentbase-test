package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import pages.landingpage.PageContentPage;
import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyPageContentTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        navigateToTalentbasePage();
    }

    public PageContentPage pageContent() {
        return new PageContentPage(getDriver());
    }

    @DisplayName("Page content functionality Test")
    @Test
    public void upperHireTalentButtonTest() {
        pageContent().navigateUpperHireTalentPage();
        assertThat("Not found Hire Talent page in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(HIRE_TALENT));
        getDriver().get(HOME_PAGE);
    }

    @Test
    public void whyUsLinkTest() {
        pageContent().navigateWhyUsPage();
        assertThat("Not found Why us page in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(WHY_US));
        getDriver().get(HOME_PAGE);
    }

    @Test
    public void lowerHireTalentButtonTest() {
        pageContent().navigateLowerHireTalentPage();
        assertThat("Not found Hire Talent page in the Talentbase site",getDriver().getCurrentUrl(), equalToIgnoringCase(HIRE_TALENT));
    }
}
