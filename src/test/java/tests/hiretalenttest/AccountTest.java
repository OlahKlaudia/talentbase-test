package tests.hiretalenttest;

import mainbase.base.ProfileTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.AccountDetailsPage;
import pages.leftpanellinkpage.StartPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class AccountTest  extends ProfileTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginHireTalentTest();
        startPage().searchTheBasePicture();
        accountDetailsPage().navigateAccount();
    }
    public StartPage startPage() {
        return new StartPage(getDriver());
    }
    public SignInTest loginAsTalent() {
        return new SignInTest();
    }

    public AccountDetailsPage accountDetailsPage() {
        return new AccountDetailsPage(getDriver());
    }
    @Test
    public void buttonDisableTest() {
        accountDetailsPage().blankFieldsHireTalent();
        assertThat(accountDetailsPage().getButtonColor(), equalToIgnoringCase(GREY));
    }
    @Test
    public void uploadImageTest() {
        accountDetailsPage().uploadImage();
        assertThat("Image is not uploaded",accountDetailsPage().uploadImage(),containsString("talentbase.com"));
    }
}
