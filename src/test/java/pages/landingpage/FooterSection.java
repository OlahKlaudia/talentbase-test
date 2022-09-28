package pages.landingpage;

import io.qameta.allure.Step;
import mainbase.mainenum.FooterElementsEnum;
import mainbase.basepage.TalentbaseLandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.headerlinks.*;
import pages.footerlinkspages.*;

import java.time.Duration;

public class FooterSection extends TalentbaseLandingPage {

    @FindBy(css = ".footer")
    private WebElement footer;

//    @FindBy(css = "footer a[href='/corp/base']:nth-child(1)")
//    private WebElement designersFooterLink;
//
//    @FindBy(css = "footer a[href='/corp/base']:nth-child(2)")
//    private WebElement developersFooterLink;
//
//    @FindBy(css = "footer a[href='/corp/base']:nth-child(3)")
//    private WebElement financialExpertsFooterLink;

    @FindBy(css = "footer a[href='/about']:nth-child(1) p")
    private WebElement whyUsFooterLink;

    @FindBy(css = "footer a[href='/blog'] p")
    private WebElement blogFooterLink;

    @FindBy(css = "footer a[href='/partners'] p")
    private WebElement partnersAndInvestorsFooterLink;

    @FindBy(css = "footer a[href='/contact'] p")
    private WebElement contactUsFooterLink;

    @FindBy(css = "footer a[href='/work'] p")
    private WebElement lookingForWorkFooterLink;

    @FindBy(css = "footer a[href='/privacyPolicy'] p")
    private WebElement ourPolicyFooterLink;

    @FindBy(css = "footer a[href='/termsOfService'] p")
    private WebElement websiteTermsFooterLink;

    public FooterSection(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ourPolicyFooterLink));
    }

    @Step("Scroll down,wait footer visibility,return Page Object.")
    public TalentbaseLandingPage clickFooterElements(FooterElementsEnum element) {
        switch (element) {
//            case designers:
//                return designersFooterLink;
//            case developers:
//                return developersFooterLink;
//            case financialExperts:
//                return financialExpertsFooterLink;
            case whyUsLink:
                navigateFooterLinksPage().scrollDown();
//                action.moveToElement(whyUsFooterLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(whyUsFooterLink)).click();
                return new AboutPage(driver);
            case blog:
                navigateFooterLinksPage().scrollDown();
//                action.moveToElement(blogFooterLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(blogFooterLink)).click();
                return new BlogPage(driver);
            case partnersAndInvestors:
                navigateFooterLinksPage().scrollDown();
//                action.moveToElement(partnersAndInvestorsFooterLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(partnersAndInvestorsFooterLink)).click();
                return new PartnersAndInvestorsPage(driver);
            case contactus:
                navigateFooterLinksPage().scrollDown();
//                action.moveToElement(contactUsFooterLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(contactUsFooterLink)).click();
                return new ContactPage(driver);
            case lookingForWork:
                navigateFooterLinksPage().scrollDown();
//                action.moveToElement(lookingForWorkFooterLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(lookingForWorkFooterLink)).click();
                return new LookingForWorkPage(driver);
            case ourPolicy:
                navigateFooterLinksPage().scrollDown();
//                action.moveToElement(ourPolicyFooterLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(ourPolicyFooterLink)).click();
                return new OurPolicyPage(driver);
            case websiteTerms:
                navigateFooterLinksPage().scrollDown();
//                action.moveToElement(websiteTermsFooterLink).perform();
                wait.until(ExpectedConditions.elementToBeClickable(websiteTermsFooterLink)).click();
                return new WebsiteTermsPage(driver);
        }
        return null;
    }
}
