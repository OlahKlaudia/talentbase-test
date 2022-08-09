package landingpage;

import mainbase.utils.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends TalentbasePage {

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

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeaderIsVisible(){
        return headerisvisible;
    }
    public void headerItemsVisibility(){
        talentbaselogomenuitem.isDisplayed();
        partnersandinvestoritem.isDisplayed();
        homemenuitem.isDisplayed();
        lookingforworkitem.isDisplayed();
        aboutitem.isDisplayed();
        contactitem.isDisplayed();
    }
     public void navigateHomePage(){
         homemenuitem.click();
     }
     public void navigatePartnersAndInvestorsPage(){
        partnersandinvestoritem.click();
     }
    public void navigateLookingForWorkPage(){
        lookingforworkitem.click();
    }
    public void navigateAboutPage(){
        aboutitem.click();
    }
    public void navigateContactPage(){
        contactitem.click();
    }
}
