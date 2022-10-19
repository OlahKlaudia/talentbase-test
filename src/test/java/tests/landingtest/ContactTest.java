package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
import mainbase.mainenum.LinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.headerlinks.ContactPage;
import pages.landingpage.LinksPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class ContactTest extends TalentbaseTestBase {

    @BeforeEach
    public void beforeContactPage() {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.CONTACT);
    }

    public ContactPage contactUsPage() {
        return new ContactPage(getDriver());
    }

    public LinksPage linksPage() {
        return new LinksPage(getDriver());
    }

    @DisplayName("Verify all blank fields in Contact us page Test")
    @Test
    public void contactUsEmptyInputTest() {
        contactUsPage().emptyInputs();
        assertThat("The send message button is clickable.", contactUsPage().getColor(), equalToIgnoringCase(GREY));

        assertThat("Missing email error message", contactUsPage().getEmailErrorMessageText(), containsString(ERROR_MESSAGE));
        assertThat("Missing name error message", contactUsPage().getNameErrorMessageText(), containsString(ERROR_MESSAGE));
        assertThat("Missing message error message", contactUsPage().getErrorMessageText(), containsString(ERROR_MESSAGE));
    }

    @DisplayName("Verify invalid email in Contact us page Test")
    @Test
    public void invalidEmailTest() {
        contactUsPage().invalidEmail();
        assertThat("Missing invalid email error message", contactUsPage().getEmailErrorMessageText(), containsString(INVALID_EMAIL_ERROR));
    }

    @DisplayName("Linked In Link Test")
    @Test
    public void linkedInLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.LINKED_IN);
        assertThat("Wrong linkedin url.", linksPage().clickAboutPageLinkElements(LinksEnum.LINKED_IN), containsString(LINKEDIN_URL));
    }

    @DisplayName("Facebook Link Test")
    @Test
    public void facebookLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.FACEBOOK);
        assertThat("Wrong facebook url.", linksPage().clickAboutPageLinkElements(LinksEnum.FACEBOOK), containsString(FACEBOOK_URL));
    }

    @DisplayName("Twitter Link Test")
    @Test
    public void twitterLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.TWITTER);
        assertThat("Wrong twitter url.", linksPage().clickAboutPageLinkElements(LinksEnum.TWITTER), containsString(TWITTER_URL));
    }

    @DisplayName("Mail Link Test")
    @Test
    public void mailLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.MAIL);
        assertThat("Wrong mail url.", linksPage().clickAboutPageLinkElements(LinksEnum.MAIL), containsString(MAIL_URL));
    }
}
