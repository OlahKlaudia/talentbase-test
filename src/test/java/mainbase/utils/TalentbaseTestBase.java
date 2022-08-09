package mainbase.utils;

import mainbase.base.TestBase;

public class TalentbaseTestBase extends TestBase {
    private static final String TALENTBASE_URL = "https://dev.thetalentbase.com/";
    public static final String HOME_PAGE = "https://dev.thetalentbase.com/";

    public TalentbasePage navigateToTalentbasePage(){
        getDriver().get(TALENTBASE_URL);
        return new TalentbasePage(getDriver());
    }
}
