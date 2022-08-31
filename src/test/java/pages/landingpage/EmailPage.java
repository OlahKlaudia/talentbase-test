package pages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailPage extends TalentbasePage {
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
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains("mail");
    }
    public void register(){

    }

    public void verifyEmail(){
        alertVerifyButton.click();
        driver.get("https://mail.google.com/mail/u/2/#inbox");
        email.sendKeys("test@digitalarcher.dev");
        nextButton.click();
        wait.until(ExpectedConditions.visibilityOf(psw));
        psw.sendKeys("4Zg9*A6Fk!p@SsUJ");
        pswNext.click();
        //todo open email
        lastEmail.click();
    }
}
