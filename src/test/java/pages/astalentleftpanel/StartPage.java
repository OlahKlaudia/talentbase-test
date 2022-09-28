package pages.astalentleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends AsTalentBasePage {
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
    @FindBy(css = ".MuiTypography-h3")
    public WebElement welcomeToTalentbaseText;
    public static final String START = "/start";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(START);
        wait.until(ExpectedConditions.visibilityOf(welcomeToTalentbaseText));
    }

    @Step("Wait until search the base picture is visible on the Start page.")
    public void waitStartPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(searchTheBasePicture)).isDisplayed();
    }

    @Step("Click the Search the base picture.")
    public void searchTheBasePicture(){
       wait.until(ExpectedConditions.visibilityOf(searchTheBasePicture)).click();
    }

    @Step("Click the search the base button.")
    public void searchTheBaseButton(){
        scrollEnd();
        wait.until(ExpectedConditions.visibilityOf(searchTheBaseButton)).click();
    }

    @Step("Click the Details picture picture.")
    public void accountDetailsPicture(){
        wait.until(ExpectedConditions.visibilityOf(accountDetailsPicture)).click();
    }

    @Step("Click account details button.")
    public void accountDetailsButton(){
        scrollEnd();
        wait.until(ExpectedConditions.visibilityOf(accountDetailsButton)).click();
    }
}
