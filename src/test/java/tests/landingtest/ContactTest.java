package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.TalentbaseTestBase;
import mainbase.mainenum.LinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.headerlinks.ContactPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class ContactTest extends TalentbaseTestBase {

    @BeforeEach
    public void navigateTalentbasePage(){
        navigateToTalentbasePage();
        contactUsPage().navigateContactPage();
    }
    public ContactPage contactUsPage(){return new ContactPage(getDriver());}

    @DisplayName("Verify all blank fields in Contact us page test")
    @Test
    public void contactUsEmptyInputTest() {
        contactUsPage().emptyInputs();
        assertThat("The send message button is clickable.",contactUsPage().getColor(), equalToIgnoringCase(GREY));

        assertThat("Missing email error message",contactUsPage().getEmailErrorMessageText(),containsString(ERROR_MESSAGE));
        assertThat("Missing name error message",contactUsPage().getNameErrorMessageText(),containsString(ERROR_MESSAGE));
        assertThat("Missing message error message",contactUsPage().getErrorMessageText(),containsString(ERROR_MESSAGE));
    }
    @DisplayName("Verify invalid email in Contact us page test")
    @Test
    public void invalidEmailTest() {
        contactUsPage().invalidEmail();
        assertThat("Missing invalid email error message",contactUsPage().getEmailErrorMessageText(),containsString(INVALID_EMAIL_ERROR));
    }
    @Test
    public void linkedInLinkTest() {
        contactUsPage().clickAboutPageLinkElements(LinksEnum.linkedIn);
        assertThat("Wrong linkedin url.", contactUsPage().clickAboutPageLinkElements(LinksEnum.linkedIn),containsString(LINKEDIN));
    }

    @Test
    public void facebookLinkTest() {
        contactUsPage().clickAboutPageLinkElements(LinksEnum.facebook);
        assertThat("Wrong facebook url.", contactUsPage().clickAboutPageLinkElements(LinksEnum.facebook),containsString(FACEBOOK));
    }

    @Test
    public void twitterLinkTest() {
        contactUsPage().clickAboutPageLinkElements(LinksEnum.twitter);
        assertThat("Wrong twitter url.", contactUsPage().clickAboutPageLinkElements(LinksEnum.twitter),containsString(TWITTER));
    }
    @Test
    public void mailLinkTest() {
        contactUsPage().clickAboutPageLinkElements(LinksEnum.mail);
        assertThat("Wrong mail url.", contactUsPage().clickAboutPageLinkElements(LinksEnum.mail),containsString(MAIL));
    }
}
