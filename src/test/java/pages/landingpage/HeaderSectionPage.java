package pages.landingpage;

import mainbase.browserenum.FooterElementsEnum;
import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderSectionPage extends TalentbasePage {

    @FindBy(css = "#app-header")
    private WebElement headerisvisible;

    @FindBy(css = ".navbar-stack a img")
    private WebElement talentbaselogomenuitem;

    @FindBy(css = ".navbar-stack a:nth-child(2)")
    private WebElement homemenuitem;

    @FindBy(css = ".navbar-stack a:nth-child(3)")
    private WebElement partnersandinvestoritem;

    @FindBy(css = ".navbar-stack a:nth-child(4)")
    private WebElement lookingforworkitem;

    @FindBy(css = ".navbar-stack a:nth-child(5)")
    private WebElement aboutitem;

    @FindBy(css = ".navbar-stack a:nth-child(6)")
    private WebElement contactitem;

    public HeaderSectionPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeaderIsVisible() {
        return headerisvisible;
    }

    public WebElement getHeaderElements(FooterElementsEnum element) {
        switch (element) {
//            case designers:
//                homemenuitem.click();
//                return homemenuitem;
//            case support:
//                talentbaselogomenuitem.click();
//                return talentbaselogomenuitem;
//            case developers:
//                partnersandinvestoritem.click();
//                return partnersandinvestoritem;
//            case financialExperts:
//                lookingforworkitem.click();
//                return lookingforworkitem;
            case whyUsLink:
                aboutitem.click();
                return aboutitem;
            case contactus:
                contactitem.click();
                return contactitem;
        }
        return null;
    }
}
