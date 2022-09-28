package tests.astalenttest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.UserTermsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Epic("Talentbase")
@Feature("Talentbase Apply As Talent Site")
public class UserTermsTest extends AsTalentTestBase {
    @BeforeEach
    public void beforeUserTerms() {
        navigateAsTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.userTerms);
    }
    public UserTermsPage userTermsPage() {
        return new UserTermsPage(getDriver());
    }

    @DisplayName("Valid input fields on the User Terms Page Test")
    @Test
    public void userTermsTest() throws InterruptedException {
        userTermsPage().fillUserTerms();
        userTermsPage().waitButton();
    }

    @DisplayName("Blank fields on the User Terms Page Test")
    @Test
    public void blankFieldUserTermsTest() {
        userTermsPage().blankFields();
        assertThat("Button is able.",userTermsPage().getColor(), equalToIgnoringCase(GREY));
    }
}
