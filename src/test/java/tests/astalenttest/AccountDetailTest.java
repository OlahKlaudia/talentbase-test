package tests.astalenttest;

import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.AccountDetailsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class AccountDetailTest extends AsTalentTestBase {
    public static final String SHORT_PHONE_NUMBER= "Number must be longer than 6 characters.";
    public static final String INVALID_PHONE_NUMBER = "Phone number format invalid.";
    public static final String INVALID_ZIPCODE = "Zipcode only accepts numeric characters";
    public static final String LONG_ZIPCODE = "Zipcode cannot be longer than 20 character.";

    @BeforeEach
    public void navigateTalentbasePage() {
        navigateHireTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.accountDetails);
    }

    public AccountDetailsPage accountDetailsPage() {
        return new AccountDetailsPage(getDriver());
    }

    @Test
    public void shortPhoneNumberTest() {
        accountDetailsPage().shortPhoneNumber();
        assertThat(accountDetailsPage().getShortPhoneNumberText(), containsString(SHORT_PHONE_NUMBER));
    }

    @Test
    public void invalidPhoneNumberTest() {
        accountDetailsPage().invalidPhoneNumber();
        assertThat(accountDetailsPage().getShortPhoneNumberText(), containsString(INVALID_PHONE_NUMBER));
    }

    @Test
    public void invalidZipCodeTest() {
        accountDetailsPage().invalidZipCode();
        assertThat(accountDetailsPage().getZipCodeText(), containsString(INVALID_ZIPCODE));
    }

    @Test
    public void longZipCodeTest() {
        accountDetailsPage().longZipCode();
        assertThat(accountDetailsPage().getZipCodeText(), containsString(LONG_ZIPCODE));
    }
    @Test
    public void buttonDisableTest() {
        accountDetailsPage().blankFields();
        assertThat(accountDetailsPage().getButtonColor(), containsString(GREY));
    }
    @Test
    public void uploadImageTest() {
        accountDetailsPage().uploadImage();
        assertThat("Image is not uploaded",accountDetailsPage().uploadImage(),containsString("talentbase.com"));
    }
}
