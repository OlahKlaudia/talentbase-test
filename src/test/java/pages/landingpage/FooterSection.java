package pages.landingpage;

import mainbase.browserenum.FooterElementsEnum;
import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.linkspages.*;

import java.time.Duration;

public class FooterSection extends TalentbasePage {

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

    @FindBy(css = "footer a[href='/about']:nth-child(2) p")
    private WebElement clientsFooterLink;

    @FindBy(css = "footer a[href='/partners'] p")
    private WebElement partnersAndInvestorsFooterLink;

    @FindBy(css = "footer a[href='/contact']:nth-child(1) p")
    private WebElement contactUsFooterLink;

    @FindBy(css = "footer a[href='/contact']:nth-child(2) p")
    private WebElement supportFooterLink;

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
            case clients:
                return clientsFooterLink;
            case partnersAndInvestors:
                return partnersAndInvestorsFooterLink;
            case contactus:
                return contactUsFooterLink;
            case support:
                return supportFooterLink;
            case faq:
                return faqFooterLink;
            case ourPolicy:
                return ourPolicyFooterLink;
            case websiteTerms:
                return websiteTermsFooterLink;
        }
        return null;
    }
    private WaitFooterElement navigateFooterLinksPage(){
        return new WaitFooterElement(driver);
    }

    public TalentbasePage clickFooterElements(FooterElementsEnum element) {
        switch (element) {
//            case designers:
//                return designersFooterLink;
//            case developers:
//                return developersFooterLink;
//            case financialExperts:
//                return financialExpertsFooterLink;
            case whyUsLink:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(whyUsFooterLink).click().perform();
//                whyUsFooterLink.click();
                return new AboutPage(driver);
            case clients:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(clientsFooterLink).click().perform();
//                clientsFooterLink.click();
                return new AboutPage(driver);
            case partnersAndInvestors:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(partnersAndInvestorsFooterLink).click().perform();
//                partnersAndInvestorsFooterLink.click();
                return new PartnersAndInvestorsPage(driver);
            case contactus:
                navigateFooterLinksPage().waitFooterVisibility();
                action.moveToElement(contactUsFooterLink).click().perform();
                return new ContactPage(driver);
            case support:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(supportFooterLink));
                action.moveToElement(supportFooterLink).click().perform();
                return new ContactPage(driver);
            case faq:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(faqFooterLink));
                action.moveToElement(faqFooterLink).click().perform();
                return new ContactPage(driver);
            case ourPolicy:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(ourPolicyFooterLink));
                action.moveToElement(ourPolicyFooterLink).click().perform();
                return new OurPolicyPage(driver);
            case websiteTerms:
                navigateFooterLinksPage().waitFooterVisibility();
                wait.until(ExpectedConditions.elementToBeClickable(websiteTermsFooterLink));
                action.moveToElement(websiteTermsFooterLink).click().perform();
                return new WebsiteTermsPage(driver);
        }
        return null;
    }
}
