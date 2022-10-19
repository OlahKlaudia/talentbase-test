package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.AccountDetailsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class AccountDetailTest extends AsTalentTestBase {
    public static final String SHORT_PHONE_NUMBER= "Number must be longer than 6 characters.";
    public static final String INVALID_PHONE_NUMBER = "Phone number format invalid.";
    public static final String INVALID_ZIPCODE = "Zipcode only accepts numeric characters";
    public static final String LONG_ZIPCODE = "Zipcode cannot be longer than 20 character.";

    @BeforeEach
    public void beforeAccountDetailsPage() {
        navigateAsTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.ACCOUNT_DETAILS);
    }

    public AccountDetailsPage accountDetailsPage() {
        return new AccountDetailsPage(getDriver());
    }

    @DisplayName("Short phone number Test")
    @Test
    public void shortPhoneNumberTest() {
        accountDetailsPage().shortPhoneNumber();
        assertThat("Get phone number error message text,and verify the user is not able to save with short phone number.", accountDetailsPage().getShortPhoneNumberText(), containsString(SHORT_PHONE_NUMBER));
    }

    @DisplayName("Invalid phone number Test")
    @Test
    public void invalidPhoneNumberTest() {
        accountDetailsPage().invalidPhoneNumber();
        assertThat("Get phone number error message text,and verify the user is not able to save with short phone number.", accountDetailsPage().getShortPhoneNumberText(), containsString(INVALID_PHONE_NUMBER));
    }

    @DisplayName("Invalid Zip code Test")
    @Test
    public void invalidZipCodeTest() {
        accountDetailsPage().invalidZipCode();
        assertThat("Get zip code error message text,and verify the user is not able to save with invalid zip code.", accountDetailsPage().getZipCodeText(), containsString(INVALID_ZIPCODE));
    }

    @DisplayName("Long zip code Test")
    @Test
    public void longZipCodeTest() {
        accountDetailsPage().longZipCode();
        assertThat("Get zip code error message text,and verify the user is not able to save with invalid zip code.", accountDetailsPage().getZipCodeText(), containsString(LONG_ZIPCODE));
    }
    @DisplayName("Verify the button is disable Test")
    @Test
    public void buttonDisableTest() {
        accountDetailsPage().blankFields();
        assertThat("Get button color,and verify the button is disable.", accountDetailsPage().getButtonColor(), containsString(GREY));
    }
    //nem jo az oldalon
//    @DisplayName("Upload Image visibility Test")
//    @Test
//    public void uploadImageTest() {
//        accountDetailsPage().uploadImage();
//        assertThat("Image is not uploaded",accountDetailsPage().uploadImage(),containsString("talentbase.com"));
//    }
}
