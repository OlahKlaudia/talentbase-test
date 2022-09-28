package mainbase.basepage;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AsTalentBasePage extends BasePage {
    public AsTalentBasePage(WebDriver driver) {
        super(driver);
    }

    public static final String LONG_CHAR = "mSLsbjtFEnwbhVxZTJgNhq4pe7t6pnciex3XFSYOYWDAjXKRn5ymSLsbjtFEnwbhVxZTJgNhq4pe7t6pnciex3XFSYOYWDAjXKRn5y";
    public static final String VALID_INPUT = "Test";

    @FindBy(css = "button[type='submit']")
    public WebElement saveSubmit;
    @FindBy(css = "div[data-aos=\"fade-right\"] .iconify--akar-icons")
    public WebElement addPlus;
    @FindBy(css = ".MuiOutlinedInput-root .MuiButtonBase-root")
    public WebElement startDate;
    @FindBy(css = ".MuiYearPicker-root .Mui-selected")
    public WebElement select2022;
    @FindBy(css = ".MuiMonthPicker-root .Mui-selected")
    public WebElement selectAug;
    @FindBy(css = ".MuiCheckbox-root")
    public WebElement checkBox;
    @FindBy(css = ".aos-init .MuiBox-root:nth-child(1)")
    public WebElement pageContent;
    @FindBy(css = ".MuiBox-root .iconify--fa6-solid:last-child")
    public WebElement deleteButton;
    @FindBy(css = ".MuiButton-textWarning")
    public WebElement yesButtonDeleteAlert;

    @Step("Get button background color.")
    public String getColor() {
        wait.until(ExpectedConditions.visibilityOf(saveSubmit));
        return saveSubmit.getCssValue("background-color");
    }

    @Step("click to add plus element.")
    public void addNew() throws InterruptedException {
            wait.until(ExpectedConditions.elementToBeClickable(addPlus));
            pageDown();
            Thread.sleep(200);
            addPlus.click();
    }

    @Step("click to delete element.")
    public void delete() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(yesButtonDeleteAlert)).click();
    }

    @Step("Wait until the button is clickable.")
    public void waitButton() throws InterruptedException {
        int maxWait = 1000 / 200;
        int i = 1;
        do {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(saveSubmit)).click();
                i++;
                System.out.println("how many times it goes through the do while" + i);
                break;
            } catch (Exception e) {
                Thread.sleep(200);
            }
        } while (i < maxWait);
    }
}
