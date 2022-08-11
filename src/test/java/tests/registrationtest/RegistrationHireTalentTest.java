package tests.registrationtest;

import mainbase.base.TalentbaseTestBase;
import org.junit.jupiter.api.Test;
import pages.registrationpage.NavigateHireTalentPage;
import pages.registrationpage.RegistrationHireTalentPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationHireTalentTest extends TalentbaseTestBase {

    public static final String COLOR_GREY = "#bdbdbd";

    @Test
    public void registrationAsHireTalent() {
        navigateToTalentbasePage();
        NavigateHireTalentPage navigateToHireTalent = new NavigateHireTalentPage(getDriver());
        navigateToHireTalent.navigateHireTalentPage();
        RegistrationHireTalentPage registrationHireTalent= new RegistrationHireTalentPage(getDriver());

        //ALL BLANK FIELDS
        registrationHireTalent.verifyUserIsAllBlank();
       // assertTrue(registrationHireTalent.getColor().contains(COLOR_GREY), "Button is able");
         //checkbox selected and the button is disable
        registrationHireTalent.verifyCheckboxSelectedButtonDisable();
    //    assertTrue(registrationHireTalent.getColor().contains(COLOR_GREY), "Button is able");

    }
}
