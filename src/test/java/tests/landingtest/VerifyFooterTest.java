package tests.landingtest;

import com.google.common.collect.Iterables;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import mainbase.browserenum.LinksEnum;
import org.openqa.selenium.OutputType;
import pages.landingpage.FooterSection;
import pages.landingpage.ScrollToBottom;
import mainbase.browserenum.FooterElementsEnum;
import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.linkspages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyFooterTest extends TalentbaseTestBase {

    @DisplayName("Footer links functionality Test")
    @Step("Footer links functionality")
    @Test
    public void footerLinksFunctionalityTest() {
        navigateToTalentbasePage();
        ScrollToBottom navigate=new ScrollToBottom(getDriver());
        navigate.waitFooterVisibility();
        FooterSection footerFunctionality = new FooterSection(getDriver());

        for (FooterElementsEnum footerElementsEnum : FooterElementsEnum.values()){
            assertTrue( footerFunctionality.getFooterElements(footerElementsEnum).isDisplayed(), "Not found links in the Talentbase site");
        }
    }

    @Test
    public void footerLinksTest() {
        HomePage homePage=navigateToTalentbasePage();
        for (FooterElementsEnum footerElementsEnum : FooterElementsEnum.values()) {
            homePage.scrollDown().waitFooterVisibility();
            homePage.footerSection().clickFooterElements(footerElementsEnum);
            getDriver().get(HOME_PAGE);
        }
    }
}
