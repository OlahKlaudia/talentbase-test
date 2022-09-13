package tests.astalenttest;

import mainbase.base.ProfileTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.CertificatesPage;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CertificatesTest extends ProfileTestBase {

    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginAsTalentTest();
        overviewPage();
        certificatesPage().navigateCertificates();
    }

    public SignInTest loginAsTalent() {
        return new SignInTest();
    }

    public CertificatesPage certificatesPage() {
        return new CertificatesPage(getDriver());
    }

    public OverviewPage overviewPage() {
        return new OverviewPage(getDriver());
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
