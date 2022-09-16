package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public WebElement getNextButton(){
        return nextButton;
    }
    public WebElement getActivateLink(){
        return activateAccountLink;
    }
    public WebElement getAlertButton(){
        return alertVerifyButton;
    }
    @Step("Click the verify Button.")
    public void navigateGmailSite() {
        alertVerifyButton.click();
        driver.get(GMAIL_URL);
    }

    @Step("Type email into the input field and click next button.")
    public void typeEmailAddressToLoginGmail(){
        email.sendKeys(EMAIL);
        nextButton.click();
    }

    @Step("Type password into the input field and click next button.")
    public void typePasswordToLoginGmail(){
        wait.until(ExpectedConditions.visibilityOf(psw));
        psw.sendKeys(PASSWORD);
        pswNext.click();
        wait.until(ExpectedConditions.visibilityOf(lastEmail));
    }
    @Step("Click last email.")
    public void verifyGetEmail(){
        wait.until(ExpectedConditions.visibilityOf(lastEmail));
        wait.until(ExpectedConditions.elementToBeClickable(lastEmail)).click();
    }
    @Step("Click activate Account Link.")
    public void clickActivateAccountLink(){
        wait.until(ExpectedConditions.elementToBeClickable(activateAccountLink)).click();
        wait.until(ExpectedConditions.visibilityOf(header));
    }

}
