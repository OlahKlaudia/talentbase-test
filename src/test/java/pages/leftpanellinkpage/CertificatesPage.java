package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class CertificatesPage extends TalentbasePage {
    public static final String CERTIFICATES = "/certificates";

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
}
