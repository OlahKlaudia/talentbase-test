package tests.landingtest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.TalentbaseTestBase;
import mainbase.mainenum.LinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.landingpage.LinksPage;
import pages.headerlinks.AboutPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
@Epic("Talentbase")
@Feature("Talentbase landing page")
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
        assertThat("Wrong linkedin url.", linksPage().clickFooterElements(LinksEnum.linkedIn),containsString(LINKEDIN));
    }

    @Test
    public void footerFacebookLinkTest() {
        linksPage().clickFooterElements(LinksEnum.facebook);
        assertThat("Wrong facebook url.", linksPage().clickFooterElements(LinksEnum.facebook),containsString(FACEBOOK));
    }

    @Test
    public void footerTwitterLinkTest() {
        linksPage().clickFooterElements(LinksEnum.twitter);
        assertThat("Wrong twitter url.", linksPage().clickFooterElements(LinksEnum.twitter),containsString(TWITTER));
    }
    @Test
    public void footerMailLinkTest() {
        linksPage().clickFooterElements(LinksEnum.mail);
        assertThat("Wrong mail url.", linksPage().clickFooterElements(LinksEnum.mail),containsString(MAIL));
    }
    @Test
    public void linkedInLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.linkedIn);
        assertThat("Wrong linkedin url.", linksPage().clickAboutPageLinkElements(LinksEnum.linkedIn),containsString(LINKEDIN));
    }

    @Test
    public void facebookLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.facebook);
        assertThat("Wrong facebook url.", linksPage().clickAboutPageLinkElements(LinksEnum.facebook),containsString(FACEBOOK));
    }

    @Test
    public void twitterLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.twitter);
        assertThat("Wrong twitter url.", linksPage().clickAboutPageLinkElements(LinksEnum.twitter),containsString(TWITTER));
    }
    @Test
    public void mailLinkTest() {
        linksPage().clickAboutPageLinkElements(LinksEnum.mail);
        assertThat("Wrong mail url.", linksPage().clickAboutPageLinkElements(LinksEnum.mail),containsString(MAIL));
    }
}

