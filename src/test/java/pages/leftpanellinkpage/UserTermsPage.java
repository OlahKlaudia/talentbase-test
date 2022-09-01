package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTermsPage extends TalentbasePage {
    @FindBy(css = ".MuiFormControl-root")
    private WebElement currentStatus;
    @FindBy(css = "li[data-value=\"AVAILABLE\"]")
    private WebElement available;
    @FindBy(css = "input[name='daysPerWeek']")
    private WebElement daysPerWeek;
    @FindBy(css = "input[name='hoursPerDay']")
    private WebElement hoursPerDay;
    @FindBy(css = "input[name='vacationDays']")
    private WebElement vacationDays;
    @FindBy(css = "input[name='availability']")
    private WebElement availability;
    //todo second parameters
    @FindBy(css = "input[name=\"currency\"]")
    private WebElement currency;
    @FindBy(css = "input[name='monthlySalary']")
    private WebElement monthlySalary;
    @FindBy(css = ".MuiSwitch-switchBase")
    private WebElement switchBrutoOrNeto;
    @FindBy(css = "li[data-value=\"DOLLAR\"]")
    private WebElement usd;
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

    public void navigateUserTerms() {
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        userTermsLink.click();
    }

    public void fillUserTerms() {
        daysPerWeek.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        hoursPerDay.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        vacationDays.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        monthlySalary.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        availability.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        currentStatus.click();
        available.click();
//        wait.until(ExpectedConditions.elementToBeClickable(currentStatus)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(available)).click();

        daysPerWeek.sendKeys("5");
        hoursPerDay.sendKeys("8");
        vacationDays.sendKeys("20");
        availability.sendKeys("1");
//        currency.click();
//        usd.click();
//        wait.until(ExpectedConditions.elementToBeClickable(currency)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(usd)).click();
        monthlySalary.sendKeys("800");
        switchBrutoOrNeto.click();
//        saveSubmit.click();
    }
    public void currency(){
        currency.click();
        usd.click();
    }
}
