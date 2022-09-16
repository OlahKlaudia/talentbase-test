package mainbase.basepage;

import mainbase.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AsTalentLeftPanelBasePage extends BasePage {
    public AsTalentLeftPanelBasePage(WebDriver driver) {
        super(driver);
    }

    //leftpanel
    @FindBy(css = "a[href='/Profile/start']")
    public WebElement startLink;

    @FindBy(css = ".MuiBox-root a[href='/profile']")
    public WebElement overviewLink;
    @FindBy(css = "a[href='/profile/skills']")
    public WebElement skillsLink;

    @FindBy(css = "a[href='/profile/languages']")
    public WebElement languageLink;

    @FindBy(css = "a[href='/profile/hobbies']")
    public WebElement hobbiesLink;

    @FindBy(css = "a[href='/profile/social']")
    public WebElement socialLinksLink;

    @FindBy(css = "a[href='/profile/evaluation']")
    public WebElement evolutionLink;

    @FindBy(css = ".MuiBox-root a[href='/profile/account']")
    public WebElement accountDetailsLink;

    @FindBy(css = "a[href='/profile/intro']")
    public WebElement introDescriptionLink;

    @FindBy(css = "a[href='/profile/experience']")
    public WebElement experienceLink;
    @FindBy(css = "a[href='/profile/certificates']")
    public WebElement certificatesLink;

    @FindBy(css = "a[href='/profile/projects']")
    public WebElement projectsLink;

    @FindBy(css = "a[href='/profile/terms']")
    public WebElement userTermsLink;

    @FindBy(css = "a[href='/profile/education']")
    public WebElement educationLink;

    @FindBy(css = ".MuiBox-root:nth-child(3) .MuiTypography-root")
    public WebElement usernameParagraphLeftPanel;
    @FindBy(css = ".MuiBox-root:nth-child(1) svg[viewBox=\"0 0 24 24\"]")
    public WebElement closeLeftPanel;

    public void closeLeftPanel() {
        closeLeftPanel.click();
    }
    public String verifyStartIsVisible() { //TODO username változhat
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        for (WebElement element : elements) {
            if(element.getText().contains("TEST321")){
                System.out.println("Left panel is nooot closed" );
            }
            else
                System.out.println("Left panel is closed, and return null.");
            return null;
        }
        return null;
    }

    public WebElement getUsername() {
        return usernameParagraphLeftPanel;
    }
}
