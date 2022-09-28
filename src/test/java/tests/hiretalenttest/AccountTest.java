package tests.hiretalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.mainenum.LeftPanelElementsEnum;
import mainbase.testbase.HireTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.AccountDetailsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Epic("Talentbase")
@Feature("Talentbase Hire Talent Site")
public class AccountTest extends HireTestBase {
    @BeforeEach
    public void beforeHireTalent() {
        navigateHireSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.accountDetails);
//        accountDetailsPage().navigateAccount();
    }
    public AccountDetailsPage accountDetailsPage() {
        return new AccountDetailsPage(getDriver());
    }

    @DisplayName("On the Account page button is disable Test")
    @Test
    public void buttonDisableTest() {
        accountDetailsPage().blankFieldsHireTalent();
        assertThat(accountDetailsPage().getButtonColor(), containsString(GREY));
    }

    @DisplayName("Verify the image is uploaded Test")
    @Test
    public void uploadImageTest() {
        accountDetailsPage().uploadImageAccount();
        assertThat("Image is not uploaded",accountDetailsPage().uploadImageAccount(),containsString("talentbase.com"));
    }
}
