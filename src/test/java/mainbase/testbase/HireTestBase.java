package mainbase.testbase;

import pages.astalentleftpanel.StartPage;
import pages.hiretalentpage.LeftPanelLinkPage;
import pages.headerlinks.HomePage;
import tests.logintest.SignInTest;

public class HireTestBase extends TalentbaseTestBase{
    public void navigateHireSite()  {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginHireTalentTest();
        startPage();
    }

    public StartPage startPage() {
        return new StartPage(getDriver());
    }

    public SignInTest loginAsTalent() {
        return new SignInTest();
    }
    public LeftPanelLinkPage clickLeftPanelItems() {
        return new LeftPanelLinkPage(getDriver());
    }
}
