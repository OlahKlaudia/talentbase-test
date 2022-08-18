package tests;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.ContactUsPage;
import pages.linkspages.ContactPage;
import pages.linkspages.PartnersAndInvestorsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ContactTest extends TalentbaseTestBase {
    public static final String COLOR_GREY = "rgba(0, 0, 0, 0.12)";
    @Test
    public void navigateContactUsTest() {
        navigateToTalentbasePage();
        PartnersAndInvestorsPage partnersAndInvestorsPage = new PartnersAndInvestorsPage(getDriver());
        partnersAndInvestorsPage.navigatePartnersAndInvestors();
        ContactUsPage contactUsPage= new ContactUsPage(getDriver());
        contactUsPage.scrollDownPartnersAndInvestors();
    }
    @Test
    public void contactUsTest() {
        navigateToTalentbasePage();
        ContactPage contactPage=new ContactPage(getDriver());
        contactPage.navigateContactPage();
        ContactUsPage contactUsPage= new ContactUsPage(getDriver());
        contactUsPage.emptyInputs();
        assertThat(contactUsPage.getColor(), equalToIgnoringCase(COLOR_GREY));

        //invalid email
        contactUsPage.invalidEmail();
//        assertThat(contactUsPage.getEmailErrorMessage(), equalToIgnoringCase(INVALID_EMAIL_ERROR));
        //whitespaces
        contactUsPage.verifyWithSpaces();
//        assertThat(contactUsPage.getEmailErrorMessage(), equalToIgnoringCase(INVALID_EMAIL_ERROR));
        contactUsPage.verifyWithLongCharacters();

    }
}
