package mainbase.utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateScreenshot {
    private static final String SCREENSHOT_FOLDER = ".\\target\\screnshots\\";
    private static final String SCREENSHOT_NAME = "Error";

    public void createScreenshotWhenFailTest(WebDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s");
        Date date = new Date();
        try {
            FileUtils.copyFile(srcFile, new File(SCREENSHOT_FOLDER + SCREENSHOT_NAME +  dateFormat.format(date) + ".png" ));
            Allure.addAttachment(SCREENSHOT_NAME+ " "+ dateFormat.format(date),new FileInputStream(srcFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
