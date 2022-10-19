package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageContentPage extends TalentbaseLandingPage {

    @FindBy(css = "a[role='button']:nth-child(1)")
    private WebElement upperHireTalentButton;

    @FindBy(css = "a[role='button']:nth-child(2)")
    private WebElement lowerHireTalentButton;

    @FindBy(css = "section a:nth-child(2)")
    private WebElement whyUsLink;
    @FindBy(css = "button .MuiSvgIcon-root")
    private WebElement scrollTop;

    public PageContentPage(WebDriver driver) {
        super(driver);
    }
    @Step("Get header element.")
    public WebElement getHeader(){
        return header;
    }

    @Step("Click upper Hire Talent button.")
    public void navigateUpperHireTalentPage(){
        logger.info("Click upper Hire Talent button.");
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.visibilityOf(upperHireTalentButton));
        action.moveToElement(upperHireTalentButton).click().perform();

    }
    @Step("Scroll down and click why Us link.")
    public void navigateWhyUsPage(){
        logger.info("Scroll down and click why Us link");
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.visibilityOf(whyUsLink));
        action.moveToElement(whyUsLink).click().perform();
    }
    @Step("Scroll down and click lower Hire Talent button.")
    public void navigateLowerHireTalentPage(){
        logger.info("Scroll down and click lower Hire Talent button.");
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();

        wait.until(ExpectedConditions.visibilityOf(lowerHireTalentButton));
        lowerHireTalentButton.click();
    }
    @Step("Scroll down and click scroll to the top button button.")
    public void waitScrollToTopButton() throws InterruptedException {
        logger.info( "Scroll down and click scroll to the top button button.");
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        int maxWait = 1000 / 200;
        int i = 1;
        do {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(scrollTop)).click();
                i++;
                System.out.println("How many times it goes through the do while" + i);
                break;
            } catch (Exception e) {
                Thread.sleep(200);
            }
        } while (i < maxWait);
    }

}
