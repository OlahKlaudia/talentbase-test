package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CertificatesPage extends TalentbasePage {
    public static final String CERTIFICATES = "/certificates";
    @FindBy(css = "[name=\"name\"]")
    public WebElement nameOfCertificate;
    @FindBy(css = "[name=\"givenBy\"]")
    public WebElement institution;
    @FindBy(css = "[name=\"field\"]")
    public WebElement field;

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(CERTIFICATES);
    }

    public CertificatesPage(WebDriver driver) {
        super(driver);
    }

    public void navigateCertificates() {
        certificatesLink.click();
        addPlus.click();
    }

    public void fillCertificates() {
        nameOfCertificate.sendKeys(VALID_INPUT);
        institution.sendKeys(VALID_INPUT);
        field.sendKeys(VALID_INPUT);

        wait.until(ExpectedConditions.elementToBeClickable(startDate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(select2022)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectAug)).click();
        //todo element is not clickable
        action.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
        wait.until(ExpectedConditions.elementToBeClickable(saveSubmit)).click();
    }
}
