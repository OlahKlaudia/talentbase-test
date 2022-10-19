package pages.astalentleftpanel;

import mainbase.basepage.AsTalentBasePage;
import org.openqa.selenium.WebDriver;

public class SkillsPage extends AsTalentBasePage {
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
