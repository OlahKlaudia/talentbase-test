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
import pages.headerlinks.AboutPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase landing page")
public class LinkTest extends TalentbaseTestBase {

    @BeforeEach
    public void beforeTalentbasePage() {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.about);
    }

    public LinksPage linksPage() {
        return new LinksPage(getDriver());
    }

    @DisplayName("Footer Visibility Test")
    @Test
    public void footerLinkedInLinkTest() {
        linksPage().clickFooterElements(LinksEnum.linkedIn);
        assertThat("Wrong linkedin url.", linksPage().clickFooterElements(LinksEnum.linkedIn), containsString(LINKEDIN));
    }

    @DisplayName("Footer Facebook Link Test")
    @Test
    public void footerFacebookLinkTest() {
        linksPage().clickFooterElements(LinksEnum.facebook);
        assertThat("Wrong facebook url.", linksPage().clickFooterElements(LinksEnum.facebook), containsString(FACEBOOK));
    }

    @DisplayName("Footer Twitter Link Test")
    @Test
    public void footerTwitterLinkTest() {
        linksPage().clickFooterElements(LinksEnum.twitter);
        assertThat("Wrong twitter url.", linksPage().clickFooterElements(LinksEnum.twitter), containsString(TWITTER));
    }

    @DisplayName("Footer Mail Link Test")
    @Test
    public void footerMailLinkTest() {
        linksPage().clickFooterElements(LinksEnum.mail);
        assertThat("Wrong mail url.", linksPage().clickFooterElements(LinksEnum.mail), containsString(MAIL));
    }

    @DisplayName("Linked In Link Test")
    @Test
    public void linkedInLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.linkedIn);
        assertThat("Wrong linkedin url.", linksPage().clickAboutPageLinkElements(LinksEnum.linkedIn), containsString(LINKEDIN));
    }

    @DisplayName("Facebook Link Test")
    @Test
    public void facebookLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.facebook);
        assertThat("Wrong facebook url.", linksPage().clickAboutPageLinkElements(LinksEnum.facebook), containsString(FACEBOOK));
    }

    @DisplayName("Twitter Link Test")
    @Test
    public void twitterLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.twitter);
        assertThat("Wrong twitter url.", linksPage().clickAboutPageLinkElements(LinksEnum.twitter), containsString(TWITTER));
    }

    @DisplayName("Mail Link Test")
    @Test
    public void mailLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.mail);
        assertThat("Wrong mail url.", linksPage().clickAboutPageLinkElements(LinksEnum.mail), containsString(MAIL));
    }
}

