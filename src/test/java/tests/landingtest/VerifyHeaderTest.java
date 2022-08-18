package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pages.landingpage.HeaderSectionPage;
import mainbase.browserenum.FooterElementsEnum;
import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyHeaderTest extends TalentbaseTestBase {

    @DisplayName("Header functionality Test")
    @Test
    public void headerFunctionalityTest() {
        navigateToTalentbasePage();
        HeaderSectionPage headerVisibility = new HeaderSectionPage(getDriver());


        assertTrue(headerVisibility.getHeaderIsVisible().isDisplayed(), "Not found the header in the Talentbase site");

        for (FooterElementsEnum headerElementsEnum : FooterElementsEnum.values()) {
//            assertTrue(headerVisibility.getHeaderElements(headerElementsEnum).isDisplayed(), "Not found the header in the Talentbase site");
            headerVisibility.getHeaderElements(headerElementsEnum);

            if (headerElementsEnum == FooterElementsEnum.whyUsLink || headerElementsEnum == FooterElementsEnum.clients) {
                assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(HOME_PAGE));
            } else if (headerElementsEnum == FooterElementsEnum.partnersAndInvestors) {
                assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(PARTNERS_AND_INVESTORS_PAGE));
            } else if (headerElementsEnum == FooterElementsEnum.contactus) {
                assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(LOOKING_FOR_WORK_PAGE));
            } else if (headerElementsEnum == FooterElementsEnum.support) {
                assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(ABOUT_PAGE));
            } else if (headerElementsEnum == FooterElementsEnum.faq) {
                assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(CONTACT_PAGE));
            } else if (headerElementsEnum == FooterElementsEnum.ourPolicy) {
                assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(BLOG_PAGE));
            }
        }
    }
        @Test
        public void homePageTest() {
            navigateToTalentbasePage();
            HeaderSectionPage headerVisibility = new HeaderSectionPage(getDriver());

            for (FooterElementsEnum headerElementsEnum : FooterElementsEnum.values()) {
                headerVisibility.getHeaderElements(headerElementsEnum);
                if (headerElementsEnum == FooterElementsEnum.whyUsLink || headerElementsEnum == FooterElementsEnum.clients) {
                    assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(HOME_PAGE));
                }
            }
        }
}
