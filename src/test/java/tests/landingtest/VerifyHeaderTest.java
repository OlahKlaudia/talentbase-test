package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.Test;
import pages.linkspages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class VerifyHeaderTest extends TalentbaseTestBase {

    @BeforeEach
    public void navigateTalentbasePage(){
        navigateToTalentbasePage();
    }
    public HomePage homePage(){return new HomePage(getDriver());}
    @Test
    public void homeLinkTest() {
        homePage().headerSection().getHeaderElements(HeaderElementsEnum.home);
        assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(HOME_PAGE));
    }
    @Test
    public void talentbaseLogoLinkTest() {
        homePage().headerSection().getHeaderElements(HeaderElementsEnum.talentbaseLogo);
        assertThat("Not found Talentbase logo link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(HOME_PAGE));
    }
    @Test
    public void partnersAndInvestorsLinkTest() {
        homePage().headerSection().getHeaderElements(HeaderElementsEnum.partnersAndInvestors);
        assertThat("Not found Partners And Investors link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(PARTNERS_AND_INVESTORS_PAGE));
    }
    @Test
    public void lookingFotWorkLinkTest() {
        homePage().headerSection().getHeaderElements(HeaderElementsEnum.lookingForWork);
        assertThat("Not found Looking for Work link in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(LOOKING_FOR_WORK_PAGE));
    }
    @Test
    public void aboutLinkTest() {
        homePage().headerSection().getHeaderElements(HeaderElementsEnum.about);
        assertThat("Not found About link  in the Talentbase site.",getDriver().getCurrentUrl(), equalToIgnoringCase(ABOUT_PAGE));
    }
    @Test
    public void contactLinkTest() {
        homePage().headerSection().getHeaderElements(HeaderElementsEnum.contact);
        assertThat("Not found Contact link in the Talentbase site",getDriver().getCurrentUrl(), equalToIgnoringCase(CONTACT_PAGE));
    }
    @Test
    public void blogLinkTest() {
        homePage().headerSection().getHeaderElements(HeaderElementsEnum.blog);
        assertThat("Not found Blog link in the Talentbase site.", getDriver().getCurrentUrl(), equalToIgnoringCase(BLOG_PAGE));
    }
}
