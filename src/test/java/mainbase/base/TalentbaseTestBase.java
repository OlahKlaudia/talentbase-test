package mainbase.base;

import pages.linkspages.HomePage;

public class TalentbaseTestBase extends TestBase {
    private static final String TALENTBASE_URL = "https://dev.thetalentbase.com/";
    public static final String HOME_PAGE = "https://dev.thetalentbase.com/";
    public static final String PARTNERS_AND_INVESTORS_PAGE = "https://dev.thetalentbase.com/partners";
    public static final String LOOKING_FOR_WORK_PAGE = "https://dev.thetalentbase.com/work";
    public static final String ABOUT_PAGE = "https://dev.thetalentbase.com/about";
    public static final String CONTACT_PAGE = "https://dev.thetalentbase.com/contact";
    public static final String BLOG_PAGE = "https://dev.thetalentbase.com/blog";
    public static final String HIRE_TALENT = "https://dev.thetalentbase.com/register";
    public static final String COLOR_GREY = "rgba(189, 189, 189, 1)";
    public static final String BLACK = "rgba(97, 97, 97, 1)";

    public HomePage navigateToTalentbasePage(){
        getDriver().get(TALENTBASE_URL);
        return new HomePage(getDriver());
    }
}
