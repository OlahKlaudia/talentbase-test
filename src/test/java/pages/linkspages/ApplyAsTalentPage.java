package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplyAsTalentPage extends TalentbasePage {
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
    public void navigateApplyTalentPage() {
        applyAsTalentMenuItem.click();
    }
}
