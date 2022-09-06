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
    private WebElement nameOfCertificate;
    @FindBy(css = "[name=\"givenBy\"]")
    private WebElement institution;
    @FindBy(css = "[name=\"field\"]")
    private WebElement field;
    @FindBy(css = "textarea[name=\"description\"]")
    private WebElement description;
    @FindBy(css = ".footer")
    private WebElement footer;

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
        wait.until(ExpectedConditions.elementToBeClickable(addPlus)).click();
//        addPlus.click();
    }

    public void fillCertificates() {
        nameOfCertificate.sendKeys(VALID_INPUT);
        institution.sendKeys(VALID_INPUT);
        field.sendKeys(VALID_INPUT);

        wait.until(ExpectedConditions.elementToBeClickable(startDate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(select2022)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectAug)).click();
    }
    public void waitButton() throws InterruptedException {
        int maxWait = 1000 / 200;
        int i = 1;
        do {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(saveSubmit)).click();
                i++;
                System.out.println("how many times it goes through the do while" + i);
                break;
            } catch (Exception e) {
                Thread.sleep(200);
            }
        } while (i < maxWait);
    }
}
