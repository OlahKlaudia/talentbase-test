package mainbase.testbase;

import pages.headerlinks.HomePage;
import pages.landingpage.HeaderSection;

import java.net.MalformedURLException;

public class TalentbaseTestBase extends TestBase {
    public static final String TALENTBASE = "https://dev.thetalentbase.com/";
    public static final String HOME_PAGE = "thetalentbase.com/";
    public static final String PARTNERS_AND_INVESTORS_PAGE = "/partners";
    public static final String LOOKING_FOR_WORK_PAGE = "/work";
    public static final String ABOUT_PAGE = "/about";
    public static final String CONTACT_PAGE = "/contact";
    public static final String SALARY = "/calculator";
    public static final String BASE = "/corp/base";
    public static final String BLOG_PAGE = "/blog";
    public static final String NOTIFICATIONS_PAGE = "/notifications";
    public static final String START_PAGE = "/corp/start";
    public static final String ACCOUNT_PAGE = "/corp/account";
    public static final String SEARCH_THE_BASE_PAGE = "/corp/base";
    public static final String MY_BASE_PAGE = "/corp/talent/";
    public static final String HIRE_TALENT = "/hire-talent";
    public static final String SIGN_UP = "/register";
    public static final String LOGIN = "/login";
    public static final String OVERVIEW = "/profile";
    public static final String OUR_POLICY = "/privacyPolicy";
    public static final String WEBSITE_TERMS = "/termsOfService";
    public static final String RESET_PASSWORD_PAGE = "/account/reset";
    public static final String LINKEDIN = "https://www.linkedin.com/company/talentbasesavicsoft";
    public static final String FACEBOOK = "https://www.facebook.com/TalentBase-";
    public static final String TWITTER = "https://twitter.com/TalentBase2022";
    public static final String MAIL = "info@thetalentbase.com";
    public static final String GMAIL = "/mail/";

    public static final String COLOR_GREY = "rgba(189, 189, 189, 1)";
    public static final String GREY = "rgba(0, 0, 0, 0.12)";
    public static final String SHORT_USERNAME_ERROR = "Username must be at least 6 characters.";
    public static final String LONG_USERNAME_ERROR = "Username must not exceed 50 characters in length.";
    public static final String LONG_CHAR_ERROR = "must be less than 100 characters";
    public static final String INVALID_USERNAME_ERROR = "Username format invalid.";
    public static final String INVALID_EMAIL_ERROR = "Please enter a valid email address";
    public static final String SHORT_PASSWORD_ERROR = "Password must be at least 8 characters long.";
    public static final String LONG_PASSWORD_ERROR = "Password can't be longer than 100 characters.";
    public static final String ERROR_MESSAGE = "is required";

    public HomePage navigateToTalentbasePage(){
        getDriver().get(TALENTBASE);
        return new HomePage(getDriver());
    }

    public HeaderSection headerSection(){
        return new HeaderSection(getDriver());
    }

}
