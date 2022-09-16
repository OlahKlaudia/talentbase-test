package tests.astalenttest;

import mainbase.testbase.AsTalentTestBase;
import mainbase.mainenum.LeftPanelElementsEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.astalentleftpanel.UserTermsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class UserTermsTest extends AsTalentTestBase {
    @BeforeEach
    public void navigateTalentbasePage() {
        navigateHireTalentSite();
        clickLeftPanelItems().clickLeftPanelElements(LeftPanelElementsEnum.userTerms);
        userTermsPage().navigateUserTerms();
    }
    public UserTermsPage userTermsPage() {
        return new UserTermsPage(getDriver());
    }
    @Test
    public void userTermsTest() throws InterruptedException {
        userTermsPage().fillUserTerms();
        userTermsPage().waitButton();
    }
    @Test
    public void blankFieldUserTermsTest() {
        userTermsPage().blankFields();
        assertThat("Button is able.",userTermsPage().getColor(), equalToIgnoringCase(GREY));
    }
}
