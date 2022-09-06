package tests.landingtest;

import mainbase.base.TalentbaseTestBase;
import mainbase.mainenum.LinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.landingpage.ContactUsPage;
import pages.linkspages.ContactPage;
import pages.linkspages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class ContactTest extends TalentbaseTestBase {
    public static final String COLOR_GREY = "rgba(0, 0, 0, 0.12)";
    @BeforeEach
    public void navigateTalentbasePage(){
        navigateToTalentbasePage();
        ContactPage contactPage=new ContactPage(getDriver());
        contactPage.navigateContactPage();
    }
    public HomePage homePage(){return new HomePage(getDriver());}
    public ContactUsPage contactUsPage(){return new ContactUsPage(getDriver());}

    @Test
    public void contactUsEmptyInputTest() {
        contactUsPage().emptyInputs();
        assertThat("The send message button is clickable.",contactUsPage().getColor(), equalToIgnoringCase(COLOR_GREY));

        assertThat("Missing email error message",contactUsPage().getEmailErrorMessageText(),containsString(ERROR_MESSAGE));
        assertThat("Missing name error message",contactUsPage().getNameErrorMessageText(),containsString(ERROR_MESSAGE));
        assertThat("Missing message error message",contactUsPage().getErrorMessageText(),containsString(ERROR_MESSAGE));
    }
    @Test
    public void invalidEmailTest() {
        contactUsPage().invalidEmail();
        assertThat("Missing invalid email error message",contactUsPage().getEmailErrorMessageText(),containsString(INVALID_EMAIL_ERROR));
    }
    @Test
    public void linkedInLinkTest() {
        contactUsPage().clickAboutPageLinkElements(LinksEnum.linkedIn);
        assertThat("Wrong linkedin url.", contactUsPage().clickAboutPageLinkElements(LinksEnum.linkedIn).contains(LINKEDIN));
    }

    @Test
    public void facebookLinkTest() {
        contactUsPage().clickAboutPageLinkElements(LinksEnum.facebook);
        assertThat("Wrong facebook url.", contactUsPage().clickAboutPageLinkElements(LinksEnum.facebook).contains(FACEBOOK));
    }

    @Test
    public void twitterLinkTest() {
        contactUsPage().clickAboutPageLinkElements(LinksEnum.twitter);
        assertThat("Wrong twitter url.", contactUsPage().clickAboutPageLinkElements(LinksEnum.twitter).contains(TWITTER));
    }
    @Test
    public void mailLinkTest() {
        contactUsPage().clickAboutPageLinkElements(LinksEnum.mail);
        assertThat("Wrong mail url.", contactUsPage().clickAboutPageLinkElements(LinksEnum.mail).contains(MAIL));
    }
}
