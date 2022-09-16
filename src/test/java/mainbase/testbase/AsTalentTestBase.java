package mainbase.testbase;

import pages.astalentleftpanel.OverviewPage;
import pages.astalentpage.LeftPanelTalentLinksPage;
import pages.headerlinks.HomePage;
import tests.logintest.SignInTest;

public class AsTalentTestBase extends TalentbaseTestBase{
    public static final String START = "/Profile/start";
    public static final String ACCOUNT_DETAILS = "/profile/account";
    public static final String CERTIFICATES = "/profile/certificates";
    public static final String EDUCATION = "/profile/education";
    public static final String EVOLUTION = "/profile/evaluation";
    public static final String EXPERIENCE = "/profile/experience";
    public static final String HOBBIES = "/profile/hobbies";
    public static final String INTRO_DESCRIPTION = "/profile/intro";
    public static final String LANGUAGE = "/profile/languages";
    public static final String OVERVIEW = "/profile";
    public static final String PROJECT = "/profile/projects";
    public static final String SKILLS = "/profile/skills";
    public static final String SOCIAL_LINK = "/profile/social";
    public static final String USER_TERMS = "/profile/terms";
    public static final String COLOR_RED = "rgba(211, 47, 47, 1)";

    public void navigateHireTalentSite() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginAsTalentTest();
        overviewPage();
    }

    public SignInTest loginAsTalent() {
        return new SignInTest();
    }
    public OverviewPage overviewPage() {
        return new OverviewPage(getDriver());
    }
    public LeftPanelTalentLinksPage clickLeftPanelItems() {
        return new LeftPanelTalentLinksPage(getDriver());
    }
}
