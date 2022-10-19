package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class EmailPage extends TalentbaseLandingPage {
    public EmailPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".MuiPaper-root button")
    private WebElement alertVerifyButton;
    @FindBy(css = "[type=\"email\"]")
    private WebElement email;
    @FindBy(css = "#identifierNext")
    private WebElement nextButton;
    @FindBy(css = "[type=\"password\"]")
    private WebElement psw;
    @FindBy(css = "#passwordNext")
    private WebElement pswNext;
    @FindBy(css = "[role=\"row\"]:nth-child(1)")
    private WebElement lastEmail;
    @FindBy(css = "table:nth-child(1) td a")
    private WebElement activateAccountLink;
    public static final String EMAIL = "test@digitalarcher.dev";
    public static final String PASSWORD = "4Zg9*A6Fk!p@SsUJ";
    public static final String GMAIL_URL = "https://mail.google.com/mail/u/2/#inbox";
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains("mail");
    }

    @Step("Get next button element.")
    public WebElement getNextButton(){
        logger.info("Get next button element.");
        return nextButton;
    }

    @Step("Get activate link element.")
    public WebElement getActivateLink(){
        logger.info("Get activate link element.");
        return activateAccountLink;
    }

    @Step("Get alert button element.")
    public WebElement getAlertButton(){
        logger.info("Get alert button element.");
        return alertVerifyButton;
    }
    @Step("Click the verify Button.")
    public void navigateGmailSite() {
        logger.info("Click the verify Button, and get gmail url.");
        alertVerifyButton.click();
        driver.get(GMAIL_URL);
    }

    @Step("Type email into the input field and click next button.")
    public void typeEmailAddressToLoginGmail(){
        logger.info("Type email into the input field and click next button.");
        email.sendKeys(EMAIL);
        nextButton.click();
    }

    @Step("Type password into the input field and click next button.")
    public void typePasswordToLoginGmail(){
        logger.info("Type password into the input field and click next button.");
        wait.until(ExpectedConditions.visibilityOf(psw));
        psw.sendKeys(PASSWORD);
        pswNext.click();
        wait.until(ExpectedConditions.visibilityOf(lastEmail));
    }
    @Step("Click last email.")
    public void verifyGetEmail(){
        logger.info("Click last email.");
        wait.until(ExpectedConditions.visibilityOf(lastEmail));
        wait.until(ExpectedConditions.elementToBeClickable(lastEmail)).click();
    }
    @Step("Click activate Account Link.")
    public void clickActivateAccountLink(){
        logger.info("Click activate Account Link, and switch to the new tab.");
        assert driver.getWindowHandles().size() == 1;
        wait.until(ExpectedConditions.elementToBeClickable(activateAccountLink)).click();
        String originalWindow = driver.getWindowHandle();
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
