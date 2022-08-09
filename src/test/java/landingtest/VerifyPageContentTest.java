package landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import landingpage.HeaderPage;
import landingpage.PageContentPage;
import mainbase.utils.TalentbaseTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyPageContentTest extends TalentbaseTestBase {
        private static final String HIRE_TALENT = "https://dev.thetalentbase.com/hire-talent";
        private static final String WHY_US = "https://dev.thetalentbase.com/about";
        @DisplayName("Page content functionality Test")
        @Step("Page content items functionality")
        @Test
        public void pageContentTest() {

            navigateToTalentbasePage();
            PageContentPage pageContent = new PageContentPage(getDriver());

            pageContent.navigateUpperHireTalentPage();
            assertTrue(getDriver().getCurrentUrl().contains(HIRE_TALENT), "Not found Hire Talent page in the Talentbase site");
            getDriver().get(HOME_PAGE);

            pageContent.navigateWhyUsPage();
            assertTrue(getDriver().getCurrentUrl().contains(WHY_US), "Not found why us page in the Talentbase site");
            getDriver().get(HOME_PAGE);

            pageContent.navigateLowerHireTalentPage();
            assertTrue(getDriver().getCurrentUrl().contains(HIRE_TALENT), "Not found Hire Talent page in the Talentbase site");
        }
}
