package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageContentPage extends TalentbasePage {

    @FindBy(css = "a[role='button']:nth-child(1)")
    private WebElement upperHireTalentButton;

    @FindBy(css = "a[role='button']:nth-child(2)")
    private WebElement lowerHireTalentButton;

    @FindBy(css = "section a:nth-child(2)")
    private WebElement whyUsLink;

    public PageContentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click upper Hire Talent button.")
    public void navigateUpperHireTalentPage(){

        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.visibilityOf(upperHireTalentButton));
        action.moveToElement(upperHireTalentButton).click().perform();

//        upperHireTalentButton.click();
    }
    @Step("Click why Us link")
    public void navigateWhyUsPage(){
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.visibilityOf(whyUsLink));
        action.moveToElement(whyUsLink).click().perform();
//        whyUsLink.click();
    }
    @Step("Scroll down and click lower Hire Talent button.")
    public void navigateLowerHireTalentPage(){
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();

        wait.until(ExpectedConditions.visibilityOf(lowerHireTalentButton));
        lowerHireTalentButton.click();
    }
}
