package landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import landingpage.HeaderPage;
import landingpage.PageContentPage;
import mainbase.utils.TalentbaseTestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyPageContentTest extends TalentbaseTestBase {
        private static final String HOME_PAGE = "https://dev.thetalentbase.com/";
        private static final String HIRE_TALENT = "https://dev.thetalentbase.com/hire-talent";
        private static final String WHY_US = "https://dev.thetalentbase.com/about";

        @Test
        public void pageContentTest() {

            navigateToTalentbasePage();
            PageContentPage pagecontent = new PageContentPage(getDriver());

            pagecontent.navigateUpperHireTalentPage();
            assertTrue(getDriver().getCurrentUrl().contains(HIRE_TALENT), "Not found home page in the Talentbase site");
            getDriver().get(HOME_PAGE);

            pagecontent.navigateWhyUsPage();
            assertTrue(getDriver().getCurrentUrl().contains(WHY_US), "Not found home page in the Talentbase site");
            getDriver().get(HOME_PAGE);

            pagecontent.navigateLowerHireTalentPage();
            assertTrue(getDriver().getCurrentUrl().contains(HIRE_TALENT), "Not found home page in the Talentbase site");
        }
}
