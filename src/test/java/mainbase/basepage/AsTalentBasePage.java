package mainbase.basepage;

import io.qameta.allure.Step;
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

    @Step("Get button background color.")
    public String getColor() {
        wait.until(ExpectedConditions.visibilityOf(saveSubmit));
        return saveSubmit.getCssValue("background-color");
    }
}
