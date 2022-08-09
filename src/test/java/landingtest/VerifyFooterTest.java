package landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import landingpage.FooterPage;
import mainbase.browserenum.ElementEnum;
import mainbase.utils.TalentbaseTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyFooterTest extends TalentbaseTestBase {
    private static final String LOG_IN = "https://dev.thetalentbase.com/login";
    private static final String ABOUT_US = "https://dev.thetalentbase.com/about";
    private static final String CONTACT_US = "https://dev.thetalentbase.com/contact";
    private static final String PARTNER_INVESTORS = "https://dev.thetalentbase.com/partners";
    private static final String OUR_POLICY = "https://dev.thetalentbase.com/privacyPolicy";
    private static final String TERMS_OF_SERVICE = "https://dev.thetalentbase.com/termsOfService";

    @DisplayName("Footer links functionality Test")
    @Step("Footer links functionality")
    @Test
    public void footerLinksFunctionalityTest() {
        navigateToTalentbasePage();
        FooterPage footerFunctionality = new FooterPage(getDriver());

        assertTrue(footerFunctionality.getFooterContent().isDisplayed(), "Not found footer  in the Talentbase site");
        footerFunctionality.footerItemsVisibility();

        for (ElementEnum elementEnum : ElementEnum.values()){
            footerFunctionality.getFooterElements(elementEnum);
            if(elementEnum==ElementEnum.designers || elementEnum==ElementEnum.developers || elementEnum==ElementEnum.financialexperts)
            {
                assertTrue(getDriver().getCurrentUrl().contains(LOG_IN), "not found this element in the footer.");
            }
            else if (elementEnum==ElementEnum.whyuslink || elementEnum==ElementEnum.clients)
            {
                assertTrue(getDriver().getCurrentUrl().contains(ABOUT_US), "not found this element in the footer.");
            }
            else if (elementEnum==ElementEnum.contactus || elementEnum==ElementEnum.support || elementEnum==ElementEnum.faq)
            {
                assertTrue(getDriver().getCurrentUrl().contains(CONTACT_US), "not found this element in the footer.");
            }
            else if (elementEnum==ElementEnum.ourpolicy)
            {
                assertTrue(getDriver().getCurrentUrl().contains(OUR_POLICY), "not found this element in the footer.");
            }
            else if (elementEnum==ElementEnum.websiteterms)
            {
                assertTrue(getDriver().getCurrentUrl().contains(TERMS_OF_SERVICE), "not found this element in the footer.");
            }
            else
            {
                assertTrue(getDriver().getCurrentUrl().contains(PARTNER_INVESTORS), "not found this element in the footer.");
            }
         getDriver().get(HOME_PAGE);
        }

    }
}
