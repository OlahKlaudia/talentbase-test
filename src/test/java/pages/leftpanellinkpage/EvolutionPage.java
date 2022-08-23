package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class EvolutionPage extends TalentbasePage {
    public static final String EVOLUTION = "/evaluation";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(EVOLUTION);
    }
    public EvolutionPage(WebDriver driver) {
        super(driver);
    }
}
