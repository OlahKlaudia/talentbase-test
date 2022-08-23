package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class SkillsPage extends TalentbasePage {
    public static final String SKILLS = "/skills";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(SKILLS);
    }
    public SkillsPage(WebDriver driver) {
        super(driver);
    }
}
