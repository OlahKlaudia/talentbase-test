package pages.astalentpage;

import io.qameta.allure.Step;
import mainbase.base.TalentbasePage;
import mainbase.mainenum.HeaderElementsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.leftpanellinkpage.OverviewPage;
import pages.linkspages.*;

import java.time.Duration;

public class AsTalentHeaderPage extends TalentbasePage {

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(blogItem));
    }

    public AsTalentHeaderPage(WebDriver driver) {
        super(driver);
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
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                aboutItem.click();
                return new AboutPage(driver);
            case contact:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                contactItem.click();
                return new ContactPage(driver);
            case salary:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                salaryItem.click();
                return new SalaryPage(driver);
            case blog:
                wait.until(ExpectedConditions.visibilityOf(header)).click();
                blogItem.click();
                return new BlogPage(driver);
//            case notification:
//                blogitem.click();
//                return new OverviewPage(driver);
            case profile:
                profileItem.click();
                return new OverviewPage(driver);
            case base:

                wait.until(ExpectedConditions.visibilityOf(header)).click();
                wait.until(ExpectedConditions.elementToBeClickable(baseItem)).click();
                return new BasePage(driver);
            case signOut:
                signOut.click();
                return new HomePage(driver);
        }
        return null;
    }
}
