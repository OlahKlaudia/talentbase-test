package mainbase.basepage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HireTalentBasePage extends BasePage {

    public HireTalentBasePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a[href=\"/corp/start\"]")
    public WebElement startLeftItem;
    @FindBy(css = "a[href=\"/corp/talent/\"]")
    public WebElement talentLeftItem;
    @FindBy(css = "a[href=\"/corp/account\"]")
    public WebElement accountLeftItem;
    @FindBy(css = ".MuiBox-root a[href=\"/corp/base\"]")
    public WebElement baseLeftItem;
    @FindBy(css = ".MuiBox-root:nth-child(1) svg[viewBox=\"0 0 24 24\"]")
    public WebElement closeLeftPanel;

    @Step("Close the left panel.")
    public void closeLeftPanel() {
        logger.info("Close the left panel.");
        closeLeftPanel.click();
    }

    @Step("Verify the left panel is closed.")
    public String verifyStartIsVisible() {
        logger.info("Verify the left panel is closed.");
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        for (WebElement element : elements) {
            if (element.getText().contains("KLAUDIA")) {
                System.out.println("Left panel is nooot closed");
            } else
                System.out.println("Left panel is closed, and return null.");
            return null;
        }
        return null;
    }
}
