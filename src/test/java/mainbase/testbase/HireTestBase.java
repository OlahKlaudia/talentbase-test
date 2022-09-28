package mainbase.testbase;

import mainbase.mainenum.HeaderElementsEnum;
import pages.astalentleftpanel.StartPage;
import pages.hiretalentpage.LeftPanelLinkPage;
import tests.logintest.SignInTest;

public class HireTestBase extends TalentbaseTestBase{
    public void navigateHireSite()  {
        navigateToTalentbasePage();
        headerSection().clickHeaderElements(HeaderElementsEnum.signIn);
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
