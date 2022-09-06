package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends TalentbasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".MuiGrid-container:nth-child(3) .MuiGrid-root:nth-child(3) img:nth-child(2)")
    private WebElement accountDetailsPicture;
    @FindBy(css = " .MuiGrid-root:nth-child(3) img:nth-child(2)")
    private WebElement searchTheBasePicture;
    @FindBy(css = ".MuiGrid-container:nth-child(3) .MuiGrid-root:nth-child(3) button")
    private WebElement accountDetailsButton;
    @FindBy(css = " .MuiGrid-root:nth-child(3) button")
    private WebElement searchTheBaseButton;
    public static final String START = "/start";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(START);
        wait.until(ExpectedConditions.visibilityOf(welcomeToTalentbaseText));
    }
    public void searchTheBasePicture(){
       wait.until(ExpectedConditions.visibilityOf(searchTheBasePicture)).click();
    }
    public void searchTheBaseButton(){
        action.sendKeys(Keys.PAGE_DOWN);
        wait.until(ExpectedConditions.visibilityOf(searchTheBaseButton)).click();
    }
    public void accountDetailsPicture(){
        wait.until(ExpectedConditions.visibilityOf(accountDetailsPicture)).click();
    }
    public void accountDetailsButton(){
        action.sendKeys(Keys.PAGE_DOWN);
        wait.until(ExpectedConditions.visibilityOf(accountDetailsButton)).click();
    }


}
