package mainbase.basepage;

import io.qameta.allure.Step;
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

    @FindBy(css = ".MuiBox-root:nth-child(1) svg[viewBox=\"0 0 24 24\"]")
    public WebElement closeLeftPanel;

    @Step("Close the left panel.")
    public void closeLeftPanel() {
        logger.info("Close the left panel.");
        closeLeftPanel.click();
    }
}
