package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.mainenum.FooterElementsEnum;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.HeaderElementsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.linkspages.*;

public class HeaderSection extends TalentbasePage {

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

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    @Step("Return header webelement,and assert header is visible.")
    public WebElement getHeaderIsVisible() {
        return headerisvisible;
    }

    @Step("Click header menu item,return webelement,and assert header elements are visible.")
    public TalentbasePage getHeaderElements(HeaderElementsEnum element) {
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
        }
        return null;
    }
}
