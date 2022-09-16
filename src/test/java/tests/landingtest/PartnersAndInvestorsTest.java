package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.headerlinks.PartnersAndInvestorsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class PartnersAndInvestorsTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage(){
        navigateToTalentbasePage();
        partnersAndInvestorsPage().navigatePartnersAndInvestors();
    }
    public PartnersAndInvestorsPage partnersAndInvestorsPage(){return new PartnersAndInvestorsPage(getDriver());}
    @Test
    public void contactUsLinkTest() {
        partnersAndInvestorsPage().clickContactUsButton();
        assertThat("Not found Contact us page in the Talentbase site.",getDriver().getCurrentUrl(),containsString(CONTACT_PAGE));
    }
    @Test
    public void becomeAPartnersLinkTest() {
        partnersAndInvestorsPage().clickBecomeAPartnerButton();
        assertThat("Not found Contact us page in the Talentbase site.",getDriver().getCurrentUrl(),containsString(CONTACT_PAGE));
    }
    @Test
    public void becomeAnInvestorLinkTest() {
       partnersAndInvestorsPage().clickBecomeAnInvestorButton();
        assertThat("Not found Contact us page in the Talentbase site.",getDriver().getCurrentUrl(),containsString(CONTACT_PAGE));
    }
}
