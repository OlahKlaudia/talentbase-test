package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.Test;
import pages.landingpage.HeaderSection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyHeaderTest extends TalentbaseTestBase {

    @BeforeEach
    public void navigateTalentbasePage() {
        navigateToTalentbasePage();
    }

    public HeaderSection headerSection() {
        return new HeaderSection(getDriver());
    }

    @Test
    public void homeLinkTest() {
        headerSection().clickHeaderElements(HeaderElementsEnum.home);
        assertThat(getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }

    @Test
    public void talentbaseLogoLinkTest() {
        headerSection().clickHeaderElements(HeaderElementsEnum.talentbaseLogo);
        assertThat("Not found Talentbase logo link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }

    @Test
    public void partnersAndInvestorsLinkTest() {
        headerSection().clickHeaderElements(HeaderElementsEnum.partnersAndInvestors);
        assertThat("Not found Partners And Investors link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(PARTNERS_AND_INVESTORS_PAGE));
    }

    @Test
    public void lookingFotWorkLinkTest() {
        headerSection().clickHeaderElements(HeaderElementsEnum.lookingForWork);
        assertThat("Not found Looking for Work link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(LOOKING_FOR_WORK_PAGE));
    }

    @Test
    public void aboutLinkTest() {
        headerSection().clickHeaderElements(HeaderElementsEnum.about);
        assertThat("Not found About link  in the Talentbase site.", getDriver().getCurrentUrl(), containsString(ABOUT_PAGE));
    }

    @Test
    public void contactLinkTest() {
        headerSection().clickHeaderElements(HeaderElementsEnum.contact);
        assertThat("Not found Contact link in the Talentbase site", getDriver().getCurrentUrl(), containsString(CONTACT_PAGE));
    }

    @Test
    public void blogLinkTest() {
        headerSection().clickHeaderElements(HeaderElementsEnum.blog);
        assertThat("Not found Blog link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(BLOG_PAGE));
    }
}
