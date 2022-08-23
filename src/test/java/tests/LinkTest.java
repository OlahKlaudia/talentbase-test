package tests;

import mainbase.base.TalentbaseTestBase;
import mainbase.mainenum.LinksEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LinksPage;
import pages.linkspages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class LinkTest extends TalentbaseTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
       HomePage homePage= navigateToTalentbasePage();
       homePage.waiting().waitFooterVisibility();
    }

    public LinksPage linksPage() {
        return new LinksPage(getDriver());
    }

    @Test
    public void linkedInLinkTest() {//todo move element problem
        linksPage().clickFooterElements(LinksEnum.linkedIn);
        assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(LINKED_IN_PAGE));
    }

    @Test
    public void facebookLinkTest() {
        linksPage().clickFooterElements(LinksEnum.facebook);
        assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(FACEBOOK_PAGE));
    }

    @Test
    public void twitterLinkTest() {
        linksPage().clickFooterElements(LinksEnum.twitter);
        assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(TWITTER_PAGE));
    }
    @Test
    public void mailLinkTest() {
        linksPage().clickFooterElements(LinksEnum.twitter);
        assertThat(getDriver().getCurrentUrl(), equalToIgnoringCase(TWITTER_PAGE));
    }
}

