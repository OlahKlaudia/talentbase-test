package mainbase.testbase;

import io.qameta.allure.Step;
import mainbase.mainenum.HeaderElementsEnum;
import pages.astalentleftpanel.OverviewPage;
import pages.astalentpage.LeftPanelTalentLinksPage;
import tests.logintest.SignInTest;

public class AsTalentTestBase extends TalentbaseTestBase{
    public static final String START = "/Profile/start";
    public static final String ACCOUNT_DETAILS_URL = "/profile/account";
    public static final String CERTIFICATES_URL = "/profile/certificates";
    public static final String EDUCATION_URL = "/profile/education";
    public static final String EVOLUTION_URL = "/profile/evaluation";
    public static final String EXPERIENCE_URL = "/profile/experience";
    public static final String HOBBIES_URL = "/profile/hobbies";
    public static final String INTRO_DESCRIPTION_URL = "/profile/intro";
    public static final String LANGUAGE_URL = "/profile/languages";
    public static final String OVERVIEW_URL = "/profile";
    public static final String PROJECT_URL = "/profile/projects";
    public static final String SKILLS_URL = "/profile/skills";
    public static final String SOCIAL_LINK_URL = "/profile/social";
    public static final String USER_TERMS_URL = "/profile/terms";
    public static final String COLOR_RED = "rgba(211, 47, 47, 1)";
    public static final String ORANGE = "rgba(241, 84, 18, 1)";

    @Step("Navigate to Apply as Talent site.")
    public void navigateAsTalentSite() {
        logger.info("Navigate to the Apply as Talent site, and log in.");
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.SIGN_IN);
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
