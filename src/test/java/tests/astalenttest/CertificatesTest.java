package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.CertificatesPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class CertificatesTest extends AsTalentTestBase {

    @BeforeEach
    public void beforeCertificates() throws InterruptedException {
        navigateAsTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.CERTIFICATES);
        certificatesPage().addNew();
    }

    public CertificatesPage certificatesPage() {
        return new CertificatesPage(getDriver());
    }

    @DisplayName("Valid input fields on the Certificates Page Test")
    @Test
    public void certificatesTest() throws InterruptedException {
        certificatesPage().fillCertificates();
        certificatesPage().waitButton();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.CERTIFICATES);
        certificatesPage().delete();
    }

    @DisplayName("Blank fields on the Certificates Page Test")
    @Test
    public void blankFieldsCertificatesTest() {
        certificatesPage().blankFields();
        assertThat("Button is able.", certificatesPage().getColor(), equalToIgnoringCase(GREY));
    }
}
