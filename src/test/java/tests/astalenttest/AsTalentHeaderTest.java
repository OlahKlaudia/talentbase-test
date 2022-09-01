package tests.astalenttest;

import mainbase.base.ProfileTestBase;
import mainbase.mainenum.HeaderElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentpage.LoginHeaderPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class AsTalentHeaderTest extends ProfileTestBase {
    @BeforeEach
    public void navigateTalentbasePage(){
        HomePage homePage=navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginTest();
    }
    public SignInTest loginAsTalent(){return new SignInTest();}
    public LoginHeaderPage asTalentHeaderPage(){return new LoginHeaderPage(getDriver());}
    @Test
    public void talentbaseLogoLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.talentbaseLogo);
        assertThat("Not found Talentbase logo link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }
    @Test
    public void partnersAndInvestorsLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.partnersAndInvestors);
        assertThat("Not found Partners And Investors link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(PARTNERS_AND_INVESTORS_PAGE));
    }
    @Test
    public void lookingFotWorkLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.lookingForWork);
        assertThat("Not found Looking for Work link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(LOOKING_FOR_WORK_PAGE));
    }
    @Test
    public void aboutLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.about);
        assertThat("Not found About link  in the Talentbase site.",getDriver().getCurrentUrl(), containsString(ABOUT_PAGE));
    }
    @Test
    public void contactLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.contact);
        assertThat("Not found Contact link in the Talentbase site",getDriver().getCurrentUrl(), containsString(CONTACT_PAGE));
    }
    @Test
    public void salaryLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.salary);
        assertThat("Not found Salary link in the Talentbase site.",getDriver().getCurrentUrl(), containsString(SALARY));
    }
    @Test
    public void blogLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.blog);
        assertThat("Not found Blog link in the Talentbase site.", getDriver().getCurrentUrl(), containsString(BLOG_PAGE));
    }
    @Test
    public void profileLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.profile);
        assertThat("Not found About link  in the Talentbase site.",getDriver().getCurrentUrl(), containsString(OVERVIEW));
    }
    @Test
    public void signOutLinkTest() {
        asTalentHeaderPage().clickHeaderElements(HeaderElementsEnum.signOut);
        assertThat("Not found Contact link in the Talentbase site",getDriver().getCurrentUrl(), containsString(HOME_PAGE));
    }
}
