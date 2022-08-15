package mainbase.utils;

import io.qameta.allure.Allure;
import mainbase.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CreateScreenshot {
    private static final String SCREENSHOT_FOLDER = "." + File.separator + "target" + File.separator +"screenshots" + File.separator ;
    public void createScreenshotWhenFailTest(WebDriver driver, String testMethodName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s");
        Date date = new Date();
        try {
            FileUtils.copyFile(srcFile, new File(SCREENSHOT_FOLDER + testMethodName + " " + dateFormat.format(date) + ".png"));
            Allure.addAttachment(testMethodName + " " + dateFormat.format(date), new FileInputStream(srcFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
