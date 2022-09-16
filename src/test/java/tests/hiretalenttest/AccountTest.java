package tests.hiretalenttest;

import mainbase.mainenum.LeftPanelElementsEnum;
import mainbase.testbase.HireTestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.AccountDetailsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

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
    @Test
    public void buttonDisableTest() {
        accountDetailsPage().blankFieldsHireTalent();
        assertThat(accountDetailsPage().getButtonColor(), containsString(GREY));
    }
    @Test
    public void uploadImageTest() {
        accountDetailsPage().uploadImage();
        assertThat("Image is not uploaded",accountDetailsPage().uploadImage(),containsString("talentbase.com"));
    }
}
