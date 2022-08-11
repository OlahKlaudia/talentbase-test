package mainbase.base;

import pages.linkspages.HomePage;

public class TalentbaseTestBase extends TestBase {
    private static final String TALENTBASE_URL = "https://dev.thetalentbase.com/";
    public static final String HOME_PAGE = "https://dev.thetalentbase.com/";
    public HomePage navigateToTalentbasePage(){
        getDriver().get(TALENTBASE_URL);
        return new HomePage(getDriver());
    }
}
