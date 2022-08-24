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
    public static final String HIRE_TALENT = "https://dev.thetalentbase.com/hire-talent";
    public static final String SIGN_UP = "https://dev.thetalentbase.com/register";
    public static final String LOGIN = "https://dev.thetalentbase.com/login";
    public static final String APPLY_AS_TALENT_PAGE = "https://dev.thetalentbase.com/register";
    public static final String WHY_US = "https://dev.thetalentbase.com/about";
    public static final String OUR_POLICY = "https://dev.thetalentbase.com/privacyPolicy";
    public static final String WEBSITE_TERMS = "https://dev.thetalentbase.com/termsOfService";
    public static final String LINKEDIN = "https://www.linkedin.com/company/talentbasesavicsoft";
    public static final String FACEBOOK = "https://www.facebook.com/TalentBase-";
    public static final String TWITTER = "https://twitter.com/TalentBase2022";
    public static final String MAIL = "info@thetalentbase.com";
    public static final String COLOR_GREY = "rgba(189, 189, 189, 1)";
    public static final String BLACK = "rgba(97, 97, 97, 1)";
    public static final String SHORT_USERNAME_ERROR = "Username must be at least 6 characters.";
    public static final String LONG_USERNAME_ERROR = "Username must not exceed 50 characters in length.";
    public static final String INVALID_USERNAME_ERROR = "Username format invalid.";
    public static final String INVALID_EMAIL_ERROR = "Please enter a valid email address";
    public static final String SHORT_PASSWORD_ERROR = "Password must be at least 8 characters long.";
    public static final String LONG_PASSWORD_ERROR = "Password can't be longer than 100 characters.";


    public HomePage navigateToTalentbasePage(){
        getDriver().get(TALENTBASE_URL);
        return new HomePage(getDriver());
    }

}
