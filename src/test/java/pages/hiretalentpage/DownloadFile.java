package pages.hiretalentpage;

import io.qameta.allure.Step;
import mainbase.basepage.HireTalentBasePage;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DownloadFile extends HireTalentBasePage {
    public DownloadFile(WebDriver driver) {
        super(driver);
    }

    @Step("Get absolute Path.")
    public static String getAppPath(String relPath) {
        String path = new File(relPath).getAbsolutePath();
        return path;
    }

    @Step("Get download Path.")
    public static String getDownloadPath() {
        logger.info("Get download path.");
        return getAppPath("C:"+ File.separator +"Users"+ File.separator +"olahk"+ File.separator + "Downloads"+ File.separator);
    }

    @Step("Wait and check the file downloaded.")
    public boolean isFileDownloaded() throws Exception {
        logger.info("Verify the file is downloaded.");
        final int SLEEP_TIME_MILLIS = 100;
        File file = new File(getDownloadedFilesPath());
        final int timeout = 60 * SLEEP_TIME_MILLIS;
        int timeElapsed = 0;
        while (timeElapsed < timeout) {
            if (file.exists()) {
//                System.out.println(getDownloadedFiles() + " is present");
                return true;
            } else {
                timeElapsed += SLEEP_TIME_MILLIS;
                Thread.sleep(SLEEP_TIME_MILLIS);
            }
        }
        return false;
    }

    @Step("Get downloaded file.")
    public File[] getDownloadedFiles() {
        logger.info("Get the download files.");
        File downloadPath = new File(getDownloadPath());
        File[] files = downloadPath.listFiles();
//        System.out.println("get Downloads" + files);
        return files;
    }

    @Step("Get last downloaded file.")
    public String getDownloadedFilesPath() {//párhuzamos futtatásnál problémába ütközhet
        logger.info("Get the Downloaded Files, and return the last downloaded file.");
        File folder = new File(getDownloadPath());
        File[] listOfFiles = folder.listFiles();
        String fileName = "";
        int i;
        for (i = 0; i < listOfFiles.length; i++) {
            fileName = listOfFiles[i].getName();
            System.out.println("get Downloads" + fileName);

        }

        Arrays.sort(listOfFiles, Comparator.comparingLong(File::lastModified));
        System.out.println("Get Downloads last: " + listOfFiles[i-1].lastModified());

        java.util.Date time=new java.util.Date((long)listOfFiles[i-1].lastModified()*1000);
        System.out.println("Last modified file: " + time +" "+ listOfFiles[i-1].getName());
        return time+listOfFiles[i-1].getName();
    }

    @Step("Verify the file size is greater than zero.")
    public boolean isFileGreaterThanZero() {
        logger.info("Verify the file greater than zero.");
        long fileSize = getDownloadedFilesPath().length();
        if (fileSize > 0)
            System.out.println("File Greater than 0");
        else
            System.out.println("File LessThanEqual to 0");
        return false;
    }

    @Step("Clean up downloads.")
    public void cleanupDownloads() {
        logger.info("Get download files and clean up.");
        for (File f : getDownloadedFiles()) {
            System.out.println("Delete" + f);
            f.delete();
        }
    }
}
