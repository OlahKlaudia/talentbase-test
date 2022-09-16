package tests.astalenttest;

import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.CertificatesPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CertificatesTest extends AsTalentTestBase {

    @BeforeEach
    public void navigateTalentbasePage() {
        navigateHireTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.certificates);
        certificatesPage().navigateCertificates();
    }
    public CertificatesPage certificatesPage() {
        return new CertificatesPage(getDriver());
    }
    @Test
    public void certificatesTest() throws InterruptedException {
      certificatesPage().fillCertificates();
      certificatesPage().waitButton();
    }
    @Test
    public void blankFieldCertificatesTest() {
        certificatesPage().blankFields();
        assertThat("Button is able.",certificatesPage().getColor(), equalToIgnoringCase(GREY));
    }
}
