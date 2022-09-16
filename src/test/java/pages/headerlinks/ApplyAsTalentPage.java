package pages.headerlinks;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplyAsTalentPage extends TalentbaseLandingPage {
    private static final String APPLY_AS_TALENT = "/register";
    @FindBy(css = "a[href='/register']")
    private WebElement applyAsTalentMenuItem;


    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(APPLY_AS_TALENT);
    }

    public ApplyAsTalentPage(WebDriver driver) {
        super(driver);
    }
    @Step("Navigate to Apply as Talent Page.")
    public void navigateApplyTalentPage() {
        applyAsTalentMenuItem.click();
    }
}
