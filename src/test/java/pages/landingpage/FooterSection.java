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

    @FindBy(css = ".footer p:nth-child(2)")
    private WebElement descriptionTitle;

    @FindBy(css = ".footer p:nth-child(3)")
    private WebElement description;

    @FindBy(css = ".footer  img")
    private WebElement talentbaseLogo;

    @FindBy(css = "footer a[href='/corp/base']:nth-child(1)")
    private WebElement designersFooterLink;

    @FindBy(css = "footer a[href='/corp/base']:nth-child(2)")
    private WebElement developersFooterLink;

    @FindBy(css = "footer a[href='/corp/base']:nth-child(3)")
    private WebElement financialExpertsFooterLink;

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

    @FindBy(css = "footer a[href='/contact']:nth-child(3) p")
    private WebElement faqFooterLink;

    @FindBy(css = "footer a[href='/privacyPolicy'] p")
    private WebElement ourPolicyFooterLink;

    @FindBy(css = "footer a[href='/termsOfService'] p")
    private WebElement websiteTermsFooterLink;

    @FindBy(css = "button svg")
    private WebElement goToTop;

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

    @Step("Return webelement,and assert footer elements are visible.")
    public WebElement getFooterElements(FooterElementsEnum element) {
        switch (element) {
//            case footer:
//                return footer;
//            case designers:
//                return designersFooterLink;
//            case developers:
//                return developersFooterLink;
//            case financialExperts:
//                return financialExpertsFooterLink;
            case whyUsLink:
                return whyUsFooterLink;
            case blog:
                return blogFooterLink;
            case partnersAndInvestors:
                return partnersAndInvestorsFooterLink;
            case contactus:
                return contactUsFooterLink;
            case lookingForWork:
                return lookingForWorkFooterLink;
            case ourPolicy:
                return ourPolicyFooterLink;
            case websiteTerms:
                return websiteTermsFooterLink;
        }
        return null;
    }

    private WaitFooterElement navigateFooterLinksPage() {
        return new WaitFooterElement(driver);
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
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(whyUsFooterLink)).click();
//                action.moveToElement(whyUsFooterLink).click().perform();
                return new AboutPage(driver);
            case blog:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(blogFooterLink)).click();
//                action.moveToElement(blogFooterLink).click().perform();
                return new BlogPage(driver);
            case partnersAndInvestors:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(partnersAndInvestorsFooterLink)).click();
//                action.moveToElement(partnersAndInvestorsFooterLink).click().perform();
                return new PartnersAndInvestorsPage(driver);
            case contactus:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(contactUsFooterLink)).click();
//                action.moveToElement(contactUsFooterLink).click().perform();
                return new ContactPage(driver);
            case lookingForWork:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(lookingForWorkFooterLink)).click();
//                action.moveToElement(lookingForWorkFooterLink).click().perform();
                return new LookingForWorkPage(driver);
            case ourPolicy:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(ourPolicyFooterLink)).click();
//                action.moveToElement(ourPolicyFooterLink).click().perform();
                return new OurPolicyPage(driver);
            case websiteTerms:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(websiteTermsFooterLink)).click();
//                action.moveToElement(websiteTermsFooterLink).click().perform();
                return new WebsiteTermsPage(driver);
        }
        return null;
    }
}
