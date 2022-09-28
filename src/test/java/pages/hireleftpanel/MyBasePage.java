package pages.hireleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.HireTalentBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyBasePage extends HireTalentBasePage {
    public MyBasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href=\"/corp/talent/\"]")
    public WebElement myBasePage;
    @FindBy(css = "button:nth-child(3)")
    public WebElement favoritesButton;
    @FindBy(css = ".MuiGrid-root div:nth-child(4) .iconify--bi")
    public WebElement checkFavoritesTalent;
    @FindBy(css = ".MuiGrid-root div:nth-child(6) hr")
    public WebElement listOfTalent;
    @FindBy(css = ".MuiGrid-root div:nth-child(4)  svg:nth-child(2)")
    public WebElement navigateToTalent;
    public static final String TALENT = "/talent";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(TALENT);
    }
//    public void navigateMyBasePage(){
//        wait.until(ExpectedConditions.elementToBeClickable(myBasePage)).click();
//    }

    @Step("Click Favorites.")
    public void checkFavorites(){
        wait.until(ExpectedConditions.elementToBeClickable(favoritesButton)).click();
    }

    @Step("Get last Favorites talent.")
    public WebElement getTalentFavorites(){
        return checkFavoritesTalent;
    }

    @Step("Navigate My base page,click Favorites, click the last talent, get Talent Page.")
    public TalentPage navigateTalentPage(){
        navigateToTalent.click();
        return new TalentPage(driver);
    }

    @Step("Count how many Talent there.")
    public void countTalents() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".MuiGrid-root div:nth-child(6) hr"));
        int elementsCount = elements.size();
        System.out.println("How many favorites talent have: " + elementsCount);
    }
}
