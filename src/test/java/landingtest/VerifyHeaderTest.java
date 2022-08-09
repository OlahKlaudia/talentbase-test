package landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import landingpage.HeaderPage;
import mainbase.utils.TalentbaseTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyHeaderTest extends TalentbaseTestBase {
    private static final String PARTNERS_AND_INVESTORS_PAGE = "https://dev.thetalentbase.com/partners";
    private static final String LOOKING_FOR_WORK_PAGE = "https://dev.thetalentbase.com/work";
    private static final String ABOUT_PAGE = "https://dev.thetalentbase.com/about";
    private static final String CONTACT_PAGE = "https://dev.thetalentbase.com/contact";

    @DisplayName("Header functionality Test")
    @Step("Header menu items functionality")
    @Test
    public void headerFunctionalityTest(){

        navigateToTalentbasePage();
        HeaderPage headerVisibility = new HeaderPage(getDriver());

        assertTrue(headerVisibility.getHeaderIsVisible().isDisplayed(), "Not found the header in the Talentbase site");
        headerVisibility.headerItemsVisibility();

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
