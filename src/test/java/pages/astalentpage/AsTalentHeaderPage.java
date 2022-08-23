package pages.astalentpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.HeaderElementsEnum;
import org.openqa.selenium.WebDriver;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.*;

public class AsTalentHeaderPage extends TalentbasePage {

    public AsTalentHeaderPage(WebDriver driver) {
        super(driver);
    }
    @Step("Click header menu item,return webelement,and assert header elements are visible.")
    public TalentbasePage clickHeaderElements(HeaderElementsEnum element) {
        switch (element) {
            case home:
                homemenuitem.click();
                return new HomePage(driver);
            case talentbaseLogo:
                talentbaselogomenuitem.click();
                return new HomePage(driver);
            case partnersAndInvestors:
                partnersandinvestoritem.click();
                return new PartnersAndInvestorsPage(driver);
            case lookingForWork:
                lookingforworkitem.click();
                return new LookingForWorkPage(driver);
            case about:
                aboutitem.click();
                return new AboutPage(driver);
            case contact:
                contactitem.click();
                return new ContactPage(driver);
            case blog:
                blogitem.click();
                return new BlogPage(driver);
//            case notification:
//                blogitem.click();
//                return new OverviewPage(driver);
            case profile:
                blogitem.click();
                return new OverviewPage(driver);
            case signOut:
                blogitem.click();
                return new HomePage(driver);
        }
        return null;
    }
}
