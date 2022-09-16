package pages.hiretalentpage;

import mainbase.basepage.HireTalentBasePage;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DownloadFile extends HireTalentBasePage {
    public DownloadFile(WebDriver driver) {
        super(driver);
    }

    private static final String FILE_FOLDER = "C" + File.separator + "Users" + File.separator + "olahk" + File.separator + "Downloads" + File.separator;

    public static String getAppPath(String relPath) {
        String path = new File(relPath).getAbsolutePath();
        return path;
    }

    public static String getDownloadPath() {
        return getAppPath("C:\\Users\\olahk\\Downloads\\");
    }

    public boolean isFileDownloaded() throws Exception {
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

    public File[] getDownloadedFiles() {
        File downloadPath = new File(getDownloadPath());
        File[] files = downloadPath.listFiles();
//        System.out.println("get Downloads" + files);
        return files;
    }

    public String getDownloadedFilesPath() {//párhuzamos futtatásnál problémába ütközhet
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

    public boolean isFileGreaterThanZero() {
        long fileSize = getDownloadedFilesPath().length();
        if (fileSize > 0)
            System.out.println("File Greater than 0");
        else
            System.out.println("File LessThanEqual to 0");
        return false;
    }

    public void cleanupDownloads() {
        for (File f : getDownloadedFiles()) {
            System.out.println("Delete" + f);
            f.delete();
        }
    }
}
