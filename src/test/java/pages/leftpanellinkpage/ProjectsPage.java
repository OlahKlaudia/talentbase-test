package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends TalentbasePage {
    public static final String PROJECT = "/projects";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(PROJECT);
    }
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }
}
