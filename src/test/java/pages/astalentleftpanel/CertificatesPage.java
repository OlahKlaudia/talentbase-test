package pages.astalentleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.AsTalentBasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class CertificatesPage extends AsTalentBasePage {
    public static final String CERTIFICATES = "/certificates";
    @FindBy(css = "[name=\"name\"]")
    private WebElement nameOfCertificate;
    @FindBy(css = "[name=\"givenBy\"]")
    private WebElement institution;
    @FindBy(css = "[name=\"field\"]")
    private WebElement field;

    @FindBy(css = "textarea[name=\"description\"]")
    private WebElement description;

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

    @Step("Fill valid data on the Certificates Page.")
    public void fillCertificates() {
        nameOfCertificate.sendKeys(VALID_INPUT);
        institution.sendKeys(VALID_INPUT);
        field.sendKeys(VALID_INPUT);

        wait.until(ExpectedConditions.elementToBeClickable(startDate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(select2022)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectAug)).click();
    }

    @Step("Verify the button is disable with blank fields.")
    public void blankFields() {
        nameOfCertificate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        institution.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        field.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}
