package landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import landingpage.HeaderPage;
import mainbase.utils.TalentbaseTestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyLandingPageTest extends TalentbaseTestBase {

    private static final String HOME_PAGE = "https://dev.thetalentbase.com/";
    private static final String PARTNERS_AND_INVESTORS_PAGE = "https://dev.thetalentbase.com/partners";
    private static final String LOOKING_FOR_WORK_PAGE = "https://dev.thetalentbase.com/work";
    private static final String ABOUT_PAGE = "https://dev.thetalentbase.com/about";
    private static final String CONTACT_PAGE = "https://dev.thetalentbase.com/contact";

    @Test
    public void header(){

        navigateToTalentbasePage();
        HeaderPage headerVisibility = new HeaderPage(getDriver());

        assertTrue(headerVisibility.getHeaderIsVisible().isDisplayed(), "Not found the header in the Talentbase site");
        headerVisibility.headerVisibility();

        headerVisibility.navigateHomePage();
        assertTrue(getDriver().getCurrentUrl().contains(HOME_PAGE), "Not found home page in the Talentbase site");

        headerVisibility.navigatePartnersAndInvestorsPage();
        assertTrue(getDriver().getCurrentUrl().contains(PARTNERS_AND_INVESTORS_PAGE), "Not found Partners&Investors page in the Talentbase site");

        headerVisibility.navigateLookingForWorkPage();
        assertTrue(getDriver().getCurrentUrl().contains(LOOKING_FOR_WORK_PAGE), "Not found Looking for Work? in the Talentbase site");

        headerVisibility.navigateAboutPage();
        assertTrue(getDriver().getCurrentUrl().contains(ABOUT_PAGE), "Not found About page in the Talentbase site");

        headerVisibility.navigateContactPage();
        assertTrue(getDriver().getCurrentUrl().contains(CONTACT_PAGE), "Not found Contact page in the Talentbase site");
   }
}
