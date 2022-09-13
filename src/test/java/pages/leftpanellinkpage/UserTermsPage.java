package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserTermsPage extends TalentbasePage {
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
    public void waitButton() throws InterruptedException {
        int maxWait=1000/200;
        int i=1;
        do{
            try {
                wait.until(ExpectedConditions.elementToBeClickable(saveSubmit)).click();
                i++;
                System.out.println("how many times it goes through the do while"+i);
                break;
            }
            catch(Exception e) {
                Thread.sleep(200);
            }
        } while (i<maxWait);
    }
    public void currency(){
        currency.click();
        usd.click();
    }
    public void blankFields() {
        daysPerWeek.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        hoursPerDay.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        vacationDays.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        availability.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        monthlySalary.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}
