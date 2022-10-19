package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.HeaderElementsEnum;
import mainbase.testbase.TalentbaseTestBase;
import mainbase.mainenum.LinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.landingpage.LinksPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class LinkTest extends TalentbaseTestBase {

    @BeforeEach
    public void beforeTalentbasePage() {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.ABOUT);
    }

    public LinksPage linksPage() {
        return new LinksPage(getDriver());
    }

    @DisplayName("Footer Visibility Test")
    @Test
    public void footerLinkedInLinkTest() {
        linksPage().clickFooterElements(LinksEnum.LINKED_IN);
        assertThat("Wrong linkedin url.", linksPage().clickFooterElements(LinksEnum.LINKED_IN), containsString(LINKEDIN_URL));
    }

    @DisplayName("Footer Facebook Link Test")
    @Test
    public void footerFacebookLinkTest() {
        linksPage().clickFooterElements(LinksEnum.FACEBOOK);
        assertThat("Wrong facebook url.", linksPage().clickFooterElements(LinksEnum.FACEBOOK), containsString(FACEBOOK_URL));
    }

    @DisplayName("Footer Twitter Link Test")
    @Test
    public void footerTwitterLinkTest() {
        linksPage().clickFooterElements(LinksEnum.TWITTER);
        assertThat("Wrong twitter url.", linksPage().clickFooterElements(LinksEnum.TWITTER), containsString(TWITTER_URL));
    }

    @DisplayName("Footer Mail Link Test")
    @Test
    public void footerMailLinkTest() {
        linksPage().clickFooterElements(LinksEnum.MAIL);
        assertThat("Wrong mail url.", linksPage().clickFooterElements(LinksEnum.MAIL), containsString(MAIL_URL));
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

