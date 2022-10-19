package pages.headerlinks;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;

public class BlogPage extends TalentbaseLandingPage {
    public BlogPage(WebDriver driver) {
        super(driver);
    }
    public static final String BLOG_PAGE = "/blog";

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(BLOG_PAGE);
//        wait.until(ExpectedConditions.urlContains("/blog"));
    }
}
