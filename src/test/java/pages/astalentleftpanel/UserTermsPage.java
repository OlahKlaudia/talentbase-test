package pages.astalentleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserTermsPage extends AsTalentBasePage {
    @FindBy(css = "#mui-5")
    private WebElement currentStatus;
    @FindBy(css = "li[data-value=\"AVAILABLE\"]")
    private WebElement available;
    @FindBy(css = "input[name='daysPerWeek']")
    private WebElement daysPerWeek;
    @FindBy(css = "input[name='hoursPerDay']")
    private WebElement hoursPerDay;
    @FindBy(css = "input[name='vacationDays']")
    private WebElement vacationDays;
    @FindBy(css = "#mui-9")
    private WebElement availability;
    @FindBy(css = "[aria-describedby=\"mui-10-helper-text\"] ")
    private WebElement currency;
    @FindBy(css = "#mui-11")
    private WebElement monthlySalary;
    @FindBy(css = ".MuiSwitch-switchBase")
    private WebElement switchBrutoOrNeto;
    @FindBy(css = "li[data-value=\"DOLLAR\"]")
    private WebElement usd;
    @FindBy(css = "a[href='/profile/terms']")
    public WebElement userTermsLink;
    public static final String USER_TERMS = "/terms";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(USER_TERMS);
    }

    public UserTermsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill the forms with valid data.")
    public void fillUserTerms() {
        logger.info("Fill the forms with valid data.");
        daysPerWeek.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        hoursPerDay.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        vacationDays.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        monthlySalary.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        availability.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        wait.until(ExpectedConditions.elementToBeClickable(currentStatus)).click();
        wait.until(ExpectedConditions.elementToBeClickable(available)).click();

        daysPerWeek.sendKeys("5");
        hoursPerDay.sendKeys("8");
        vacationDays.sendKeys("20");
        availability.sendKeys("1");

        wait.until(ExpectedConditions.elementToBeClickable(currency)).click();
        wait.until(ExpectedConditions.elementToBeClickable(usd)).click();
        monthlySalary.sendKeys("800");
        switchBrutoOrNeto.click();
    }

    @Step("Verify the button is disable with blank fields.")
    public void blankFields() {
        logger.info("Clear the input fields.");
        daysPerWeek.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        hoursPerDay.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        vacationDays.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        availability.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        monthlySalary.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}
