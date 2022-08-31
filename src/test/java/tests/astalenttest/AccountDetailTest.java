package tests.astalenttest;

import mainbase.base.ProfileTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.leftpanellinkpage.AccountDetailsPage;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.HomePage;
import tests.logintest.SignInTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class AccountDetailTest extends ProfileTestBase {
    public static final String SHORT_PHONE_NUMBER= "Number must be longer than 6 characters.";
    public static final String INVALID_PHONE_NUMBER = "Phone number format invalid.";
    public static final String INVALID_ZIPCODE = "Zipcode only accepts numeric characters";
    public static final String LONG_ZIPCODE = "Zipcode cannot be longer than 20 character.";
    @BeforeEach
    public void navigateTalentbasePage() {
        HomePage homePage = navigateToTalentbasePage();
        homePage.signInPage().navigateSignIn();
        loginAsTalent().loginTest();
        overviewPage();
        accountDetailsPage().navigateAccountDetails();
    }
    public OverviewPage overviewPage(){return new OverviewPage(getDriver());}
    public SignInTest loginAsTalent() {
        return new SignInTest();
    }

    public AccountDetailsPage accountDetailsPage() {
        return new AccountDetailsPage(getDriver());
    }

    @Test
    public void shortPhoneNumber() {
        accountDetailsPage().shortPhoneNumber();
        assertThat(accountDetailsPage().getShortPhoneNumberText(), equalToIgnoringCase(SHORT_PHONE_NUMBER));
    }

    @Test
    public void invalidPhoneNumber() {
        accountDetailsPage().invalidPhoneNumber();
        assertThat(accountDetailsPage().getShortPhoneNumberText(), equalToIgnoringCase(INVALID_PHONE_NUMBER));
    }

    @Test
    public void invalidZipCode() {
        accountDetailsPage().invalidZipCode();
        assertThat(accountDetailsPage().getZipCodeText(), equalToIgnoringCase(INVALID_ZIPCODE));
    }

    @Test
    public void longZipCode() {
        accountDetailsPage().longZipCode();
        assertThat(accountDetailsPage().getZipCodeText(), equalToIgnoringCase(LONG_ZIPCODE));
    }
}
