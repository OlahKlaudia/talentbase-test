package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.HeaderElementsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.linkspages.*;

public class HeaderSection extends TalentbasePage {

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    @Step("Return header webelement,and assert header is visible.")
    public WebElement getHeaderIsVisible() {
        return headerIsVisible;
    }

    @Step("Click header menu item,return webelement,and assert header elements are visible.")
    public TalentbasePage clickHeaderElements(HeaderElementsEnum element) {
        switch (element) {
            case home:
                homeMenuItem.click();
                return new HomePage(driver);
            case talentbaseLogo:
                talentbaseLogoMenuItem.click();
                return new HomePage(driver);
            case partnersAndInvestors:
                partnersAndInvestorItem.click();
                return new PartnersAndInvestorsPage(driver);
            case lookingForWork:
                lookingForWorkItem.click();
                return new LookingForWorkPage(driver);
            case about:
                aboutItem.click();
                return new AboutPage(driver);
            case contact:
                contactItem.click();
                return new ContactPage(driver);
            case blog:
                blogItem.click();
                return new BlogPage(driver);
        }
        return null;
    }
}
