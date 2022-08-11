package pages.landingpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageContentPage extends TalentbasePage {

    @FindBy(css = "a[role='button']:nth-child(1)")
    private WebElement upperhiretalentbutton;

    @FindBy(css = "a[role='button']:nth-child(2)")
    private WebElement lowerhiretalentbutton;

    @FindBy(css = "section a:nth-child(2)")
    private WebElement whyuslink;

    public PageContentPage(WebDriver driver) {
        super(driver);
    }

    public void navigateUpperHireTalentPage(){
        wait.until(ExpectedConditions.visibilityOf(upperhiretalentbutton));
        upperhiretalentbutton.click();
    }
    public void navigateWhyUsPage(){
        wait.until(ExpectedConditions.visibilityOf(whyuslink));
        whyuslink.click();
    }
    public void navigateLowerHireTalentPage(){
        wait.until(ExpectedConditions.visibilityOf(upperhiretalentbutton));
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();

        wait.until(ExpectedConditions.visibilityOf(lowerhiretalentbutton));
        lowerhiretalentbutton.click();
    }
}
