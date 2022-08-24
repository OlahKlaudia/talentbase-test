package tests.landingtest;

import mainbase.base.TalentbaseTestBase;
import mainbase.mainenum.LinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.landingpage.LinksPage;
import pages.linkspages.AboutPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class LinkTest extends TalentbaseTestBase {

    @BeforeEach
    public void navigateTalentbasePage() {
        navigateToTalentbasePage();
        AboutPage aboutPage= new AboutPage(getDriver());
        aboutPage.navigateAboutPage();
    }

    public LinksPage linksPage() {
        return new LinksPage(getDriver());
    }

    @Test
    public void footerLinkedInLinkTest() {
        linksPage().clickFooterElements(LinksEnum.linkedIn);
        assertThat("Wrong linkedin url.", linksPage().clickFooterElements(LinksEnum.linkedIn).contains(LINKEDIN));
    }

    @Test
    public void footerFacebookLinkTest() {
        linksPage().clickFooterElements(LinksEnum.facebook);
        assertThat("Wrong facebook url.", linksPage().clickFooterElements(LinksEnum.facebook).contains(FACEBOOK));
    }

    @Test
    public void footerTwitterLinkTest() {
        linksPage().clickFooterElements(LinksEnum.twitter);
        assertThat("Wrong twitter url.", linksPage().clickFooterElements(LinksEnum.twitter).contains(TWITTER));
    }
    @Test
    public void footerMailLinkTest() {
        linksPage().clickFooterElements(LinksEnum.mail);
        assertThat("Wrong mail url.", linksPage().clickFooterElements(LinksEnum.mail).contains(MAIL));
    }
    @Test
    public void linkedInLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.linkedIn);
        assertThat("Wrong linkedin url.", linksPage().clickAboutPageLinkElements(LinksEnum.linkedIn).contains(LINKEDIN));
    }

    @Test
    public void facebookLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.facebook);
        assertThat("Wrong facebook url.", linksPage().clickAboutPageLinkElements(LinksEnum.facebook).contains(FACEBOOK));
    }

    @Test
    public void twitterLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.twitter);
        assertThat("Wrong twitter url.", linksPage().clickAboutPageLinkElements(LinksEnum.twitter).contains(TWITTER));
    }
    @Test
    public void mailLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.mail);
        assertThat("Wrong mail url.", linksPage().clickAboutPageLinkElements(LinksEnum.mail).contains(MAIL));
    }
}

