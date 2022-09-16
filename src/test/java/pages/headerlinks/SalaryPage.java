package pages.headerlinks;

import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;

public class SalaryPage extends TalentbaseLandingPage {
    public SalaryPage(WebDriver driver) {
        super(driver);
    }
    private static final String SALARY_PAGE = "/calculator";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(SALARY_PAGE);
    }

}
