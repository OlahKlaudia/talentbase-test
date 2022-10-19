package pages.hireleftpanel;

import io.qameta.allure.Step;
import mainbase.basepage.HireTalentBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchTheBasePage extends HireTalentBasePage {
    public SearchTheBasePage(WebDriver driver) {
        super(driver);
    }

    public static final String VALID_INPUT_JAVA = "java";
    public static final String VALID_INPUT_TWO = "software engineer";
    public static final String INVALID_INPUT = "jav";
    public static final String SEND_MESSAGE_TEXT = "Send message text test.";

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
    @FindBy(css = ".MuiGrid-container a:first-child .MuiGrid-container input")
    public WebElement export;
    @FindBy(css = ".MuiButtonBase-root:nth-child(2)")
    public WebElement downloadExport;
    @FindBy(css = ".MuiGrid-container a:first-child .aos-init")
    public WebElement resultUser;
    //no
    @FindBy(css = ".MuiGrid-container:first-child svg")
    public WebElement bookmarkUser;
    @FindBy(css = ".MuiGrid-container:first-child g")
    public WebElement clickableBookmark;
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
    @FindBy(css = ".MuiGrid-container a:first-child img:nth-child(2)")
    public WebElement checkmarks;
    @FindBy(css = ".MuiTooltip-tooltip")
    public WebElement checkmarksHover;
    @FindBy(css = ".MuiTooltip-popper")
    public WebElement salaryHover;
    public static final String SEARCH_THE_BASE = "/base";

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(SEARCH_THE_BASE);
    }

    @Step("Get cant find what you looking for image.")
    public WebElement getNoResult() {
        logger.info("Get cant find what you looking for image.");
        return cantFindWhatLookingForImage;
    }

    @Step("Get like css color.")
    public String getLikeColor() {
        logger.info("Get like css color.");
        return like.getCssValue("color");
    }

    @Step("Type invalid email into the input field.")
    public String getBookmarkColor() {
        logger.info("Type invalid email into the input field.");
        return bookmarkResult.getCssValue("color");
    }

    @Step("Get user bookmark background color.")
    public String getUserBookmarkColor() {
        logger.info("Get user bookmark background color.");
        action.moveToElement(bookmarkUser).perform();
        return bookmarkUser.getCssValue("background-color");
    }
//    public WebElement getBookmark(){
//        return clickableBookmark;
//    }

    @Step("Get export background color.")
    public String getExportColor() {
        logger.info("Get user bookmark background color.");
        return downloadExport.getCssValue("background-color");
    }

    @Step("Get next button element.")
    public WebElement getNextButton() {
        logger.info("Get next button element.");
        return nextButtonAlert;
    }

    @Step("Get contact button element.")
    public WebElement getContactNextButton() {
        logger.info("Get contact button element.");
        return contactButton;
    }

    @Step("Verify the hover is visible.")
    public String verifyCheckmarks() {
        logger.info("Verify the hover is visible.");
        wait.until(ExpectedConditions.elementToBeClickable(checkmarks));
        action.moveToElement(checkmarks).build().perform();
        wait.until(ExpectedConditions.visibilityOf(checkmarksHover));
        return checkmarksHover.getText();
    }

    @Step("Verify the hover is visible.")
    public String verifyHoverSalary() {
        logger.info("Verify the hover is visible.");
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        for (WebElement element : elements) {
            if (element.getText().contains("/mo")) {
                System.out.println("Paragraph text:" + element.getText());
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            }
        }
        action.moveToElement(salaryHover).click().perform();
        return salaryHover.getText();
    }

    //    public void navigateTheBase() {
//        action.moveToElement(baseLeftItem).perform();
//        wait.until(ExpectedConditions.elementToBeClickable(baseLeftItem)).click();
//    }
    @Step("Fill the form with valid data.")
    public void validSearch() {
        logger.info("Fill the forms with valid data.");
        inputSearch.sendKeys(VALID_INPUT_JAVA);
        action.sendKeys(Keys.ENTER).perform();
    }

    @Step("Fill the form with invalid data.")
    public void invalidSearch() {
        logger.info("Fill the forms with invalid data.");
        inputSearch.sendKeys(INVALID_INPUT);
        action.sendKeys(Keys.ENTER).perform();
    }

    @Step("Fill the form with lowercase data.")
    public void lowercaseSearch() {
        logger.info("Fill the form with lowercase data.");
        inputSearch.sendKeys(VALID_INPUT_TWO);
        action.sendKeys(Keys.ENTER).perform();
    }

    @Step("Click result like element.")
    public void verifyResultLikeElement() {
        logger.info("Click result like element.");
        like.click();
    }

    @Step("Click bookmark element.")
    public void verifyResultBookmarkElement() {
        logger.info("Click bookmark element.");
        bookmarkResult.click();
        action.moveToElement(like).perform();
    }

    @Step("Click result export element.")
    public void verifyResultExportElement() {
        logger.info("Click result export element.");
        export.click();
        action.moveToElement(like).perform();
    }

    @Step("Click to download the file.")
    public void verifyDownloadExport() {
        logger.info("Click to download the file.");
        action.moveToElement(downloadExport).perform();
        wait.until(ExpectedConditions.elementToBeClickable(downloadExport)).click();
    }

    @Step("Click back button element.")
    public SearchTheBasePage backButton() {
        logger.info("Click back button element.");
        action.moveToElement(backButton).click().perform();
        return new SearchTheBasePage(driver);
    }

    @Step("Click result user.")
    public void resultUserClick() {
        logger.info("Click result user.");
        wait.until(ExpectedConditions.elementToBeClickable(resultUser)).click();
    }

    @Step("Click bookmark element.")
    public void bookmarkAssertion() {
        logger.info("Click bookmark element.");
        wait.until(ExpectedConditions.elementToBeClickable(bookmarkUser)).click();
        action.moveToElement(hireButton).perform();
    }

    @Step("Click to hire talent button.")
    public void hireTalentButton() {
        logger.info("Click to hire talent button.");
        wait.until(ExpectedConditions.elementToBeClickable(hireButton)).click();
    }

    @Step("Click hire talent alert next button.")
    public void hireTalentAlertsClick() {
        logger.info("Click hire talent alert next button.");
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonAlert)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(nextButtonAlert)).click();
    }

    @Step("Click contact button.")
    public void contactTalent() {
        logger.info("Click contact button.");
        wait.until(ExpectedConditions.elementToBeClickable(contactButton)).click();
    }

    @Step("Click message textarea.")
    public void sendMessage() {
        logger.info("Click message textarea.");
        wait.until(ExpectedConditions.visibilityOf(messageTextarea)).click();
        messageTextarea.sendKeys(SEND_MESSAGE_TEXT);
        searchButton.click();
    }
}
