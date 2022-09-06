package tests.astalenttest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.linkspages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class PartnersAndInvestorsTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage(){
        HomePage homePage=navigateToTalentbasePage();
        homePage.partnersAndInvestorsPage().navigatePartnersAndInvestors();
    }
    public HomePage homePage(){return new HomePage(getDriver());}
    @Test
    public void contactUsLinkTest() {
        homePage().partnersAndInvestorsPage().clickContactUsButton();
        assertThat("Not found Contact us page in the Talentbase site.",getDriver().getCurrentUrl(),containsString(CONTACT_PAGE));
    }
    @Test
    public void becomeAPartnersLinkTest() {
        homePage().partnersAndInvestorsPage().clickBecomeAPartnerButton();
        assertThat("Not found Contact us page in the Talentbase site.",getDriver().getCurrentUrl(),containsString(CONTACT_PAGE));
    }
    @Test
    public void becomeAnInvestorLinkTest() {
        homePage().partnersAndInvestorsPage().clickBecomeAnInvestorButton();
        assertThat("Not found Contact us page in the Talentbase site.",getDriver().getCurrentUrl(),containsString(CONTACT_PAGE));
    }
}
