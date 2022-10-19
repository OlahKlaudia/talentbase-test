package pages.hiretalentpage;

import io.qameta.allure.Step;
import mainbase.basepage.BasePage;
import mainbase.basepage.HireTalentBasePage;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.hireleftpanel.*;
import pages.astalentleftpanel.AccountDetailsPage;
import pages.astalentleftpanel.StartPage;

public class LeftPanelLinkPage extends HireTalentBasePage {
    public LeftPanelLinkPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {
    }

    public static final String START_PAGE = "/corp/start";

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(START_PAGE);
    }

    @Step("Click left panel elements,and return Page Object.")
    public BasePage clickLeftPanelElements(LeftPanelElementsEnum element) {
        switch (element) {
            case START:
                logger.info(element.toString());
                action.moveToElement(startLeftItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(startLeftItem)).click();
                return new StartPage(driver);
            case ACCOUNT_DETAILS:
                logger.info(element.toString());
                action.moveToElement(accountLeftItem).perform();
                wait.until(ExpectedConditions.visibilityOf(accountLeftItem)).click();
                return new AccountDetailsPage(driver);
            case SEARCH_THE_BASE:
                logger.info(element.toString());
                action.moveToElement(baseLeftItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(baseLeftItem)).click();
                return new SearchTheBasePage(driver);
            case MY_BASE:
                logger.info(element.toString());
                action.moveToElement(talentLeftItem).perform();
                wait.until(ExpectedConditions.elementToBeClickable(talentLeftItem)).click();
                return new MyBasePage(driver);
        }
        return null;
    }
}
