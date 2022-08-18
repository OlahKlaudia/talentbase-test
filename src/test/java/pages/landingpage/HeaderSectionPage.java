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

    @FindBy(css = ".navbar-stack a[href='/']")
    private WebElement homemenuitem;

    @FindBy(css = ".navbar-stack a[href='/partners']")
    private WebElement partnersandinvestoritem;

    @FindBy(css = ".navbar-stack a[href='/work']")
    private WebElement lookingforworkitem;

    @FindBy(css = ".navbar-stack a[href='/about']")
    private WebElement aboutitem;

    @FindBy(css = ".navbar-stack a[href='/contact']")
    private WebElement contactitem;

    @FindBy(css = ".navbar-stack a[href='/blog']")
    private WebElement blogitem;

    public HeaderSectionPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeaderIsVisible() {
        return headerisvisible;
    }

    public WebElement getHeaderElements(FooterElementsEnum element) {
        switch (element) {
            case whyUsLink:
                homemenuitem.click();
                return homemenuitem;
            case clients:
                talentbaselogomenuitem.click();
                return talentbaselogomenuitem;
            case partnersAndInvestors:
                partnersandinvestoritem.click();
                return partnersandinvestoritem;
            case contactus:
                lookingforworkitem.click();
                return lookingforworkitem;
            case support:
                aboutitem.click();
                return aboutitem;
            case faq:
                contactitem.click();
                return contactitem;
            case ourPolicy:
                blogitem.click();
                return blogitem;
        }
        return null;
    }
}
