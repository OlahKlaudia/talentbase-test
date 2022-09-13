package pages.leftpanellinkpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchTheBasePage extends TalentbasePage {
    public SearchTheBasePage(WebDriver driver) {
        super(driver);
    }

    public static final String VALID_INPUT_JAVA = "java";
    public static final String VALID_INPUT_TWO = "software engineer";
    public static final String INVALID_INPUT = "jav";

    @FindBy(css = "[name=\"query\"]")
    public WebElement inputSearch;
    @FindBy(css = ".MuiButton-root:nth-child(1)")
    public WebElement searchButton;
    @FindBy(css = ".MuiGrid-container img")
    public WebElement cantFindWhatLookingForImage;
    @FindBy(css = ".MuiGrid-container a:first-child  [viewBox=\"0 0 20 20\"] path")
    public WebElement like;
    @FindBy(css = ".aos-init .MuiGrid-item svg:nth-child(1)")
    public WebElement bookmarkResult;
    @FindBy(css = ".MuiGrid-container a:first-child .MuiGrid-container  input ")
    public WebElement export;
    @FindBy(css = ".MuiButtonBase-root:nth-child(2)")
    public WebElement downloadExport;
    @FindBy(css = ".MuiGrid-container a:first-child .aos-init")
    public WebElement resultUser;
    //no
    @FindBy(css = ".MuiGrid-container:first-child svg")
    public WebElement bookmarkUser;
    @FindBy(css = ".aos-init button:nth-child(1)")
    public WebElement hireButton;
    @FindBy(css = ".aos-init button:nth-child(2)")
    public WebElement contactButton;

    @FindBy(css = ".MuiPaper-root button")
    public WebElement nextButtonAlert;
    @FindBy(css = ".MuiPaper-root .MuiOutlinedInput-root textarea")
    public WebElement messageTextarea;
    @FindBy(css = ".MuiGrid-item button")
    private WebElement backButton;
    @FindBy(css = ".MuiDialogActions-root button:nth-child(2)")
    public WebElement sendButtonAlert;
    public static final String SEARCH_THE_BASE = "/base";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(SEARCH_THE_BASE);
//        wait.until(ExpectedConditions.visibilityOf(inputSearch));
    }

    public WebElement getNoResult() {
        return cantFindWhatLookingForImage;
    }
    public String getLikeColor() {
        return like.getCssValue("color");
    }
    public String getBookmarkColor() {
        return bookmarkResult.getCssValue("color");
    }
    public String getUserBookmarkColor() {
        return bookmarkUser.getCssValue("color");
    }
    public String getExportColor() {
        return downloadExport.getCssValue("background-color");
    }
    public WebElement getNextButton() {
        return nextButtonAlert;
    }
    public WebElement getContactNextButton() {
        return contactButton;
    }
    public void navigateTheBase() {
        action.moveToElement(baseLeftItem).perform();
        wait.until(ExpectedConditions.elementToBeClickable(baseLeftItem)).click();
    }

    public void validSearch() {
        inputSearch.sendKeys(VALID_INPUT_JAVA);
        action.sendKeys(Keys.ENTER).perform();
    }

    public void invalidSearch() {
        inputSearch.sendKeys(INVALID_INPUT);
        action.sendKeys(Keys.ENTER).perform();
    }
    public void lowercaseSearch() {
        inputSearch.sendKeys(VALID_INPUT_TWO);
        action.sendKeys(Keys.ENTER).perform();
    }

    public void verifyResultElements() {
        like.click();
        bookmarkResult.click();
        export.click();
    }
    public void verifyDownloadExport() {
        action.moveToElement(downloadExport).perform();
        wait.until(ExpectedConditions.elementToBeClickable(downloadExport)).click();
    }
    public SearchTheBasePage backButton() {
        action.moveToElement(backButton).click().perform();
        return new SearchTheBasePage(driver);
    }
    public void resultUserClick(){
        wait.until(ExpectedConditions.elementToBeClickable(resultUser)).click();
    }
    public void bookmarkAssertion() {
        wait.until(ExpectedConditions.elementToBeClickable(bookmarkUser)).click();
    }

    public void hireTalentButton() {
        wait.until(ExpectedConditions.elementToBeClickable(hireButton)).click();
    }
    public void hireTalentAlertsClick() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonAlert)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonAlert)).click();
    }
    public void contactTalent() {
        wait.until(ExpectedConditions.elementToBeClickable(contactButton)).click();
    }
    public void sendMessage() {
        wait.until(ExpectedConditions.visibilityOf(messageTextarea)).click();
        messageTextarea.sendKeys(VALID_INPUT);
        searchButton.click();
    }
}
