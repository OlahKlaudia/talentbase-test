package tests.astalenttest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.CertificatesPage;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

public class CertificatesTest extends TalentbaseTestBase {

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
}
