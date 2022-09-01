package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogPage extends TalentbasePage {
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
