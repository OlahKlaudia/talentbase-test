package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import pages.landingpage.HeaderSectionPage;
import mainbase.browserenum.FooterElementsEnum;
import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        HeaderSectionPage headerVisibility = new HeaderSectionPage(getDriver());

        assertTrue(headerVisibility.getHeaderIsVisible().isDisplayed(), "Not found the header in the Talentbase site");

        for (FooterElementsEnum footerElementsEnum : FooterElementsEnum.values()) {

//            assertTrue(headerVisibility.getHeaderElements(elementEnum).isDisplayed(), "Not found the header in the Talentbase site");
            headerVisibility.getHeaderElements(footerElementsEnum);

//            if (elementEnum == ElementEnum.designers || elementEnum == ElementEnum.support) {
//                setAssertUrl(HOME_PAGE);
//            } else if (elementEnum == ElementEnum.developers ) {
//                setAssertUrl(PARTNERS_AND_INVESTORS_PAGE);
//            }
//            else if (elementEnum == ElementEnum.financialExperts) {
//                setAssertUrl(LOOKING_FOR_WORK_PAGE);
//            }
            if (footerElementsEnum == FooterElementsEnum.whyUsLink) {
                setAssertUrl(ABOUT_PAGE);
            }
            else if (footerElementsEnum == FooterElementsEnum.contactus ) {
                setAssertUrl(CONTACT_PAGE);
            }
        }
   }
    @ParameterizedTest
    @ValueSource(strings = {PARTNERS_AND_INVESTORS_PAGE, LOOKING_FOR_WORK_PAGE, ABOUT_PAGE, CONTACT_PAGE})
    void setAssertUrl(String assertUrl) {
        assertTrue(getDriver().getCurrentUrl().contains(assertUrl), "not found this element in the footer.");
    }
}
