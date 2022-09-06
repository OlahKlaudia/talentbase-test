package pages.hiretalentpage;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class DownloadFile extends TalentbasePage {
    public DownloadFile(WebDriver driver) {
        super(driver);
    }

//    private static final String FILE_FOLDER = "." + File.separator + "target" + File.separator + "download" + File.separator;

    //    private static final String PATH = "C:\Users\olahk\Downloads" ;
    public static String getAppPath(String relPath) {
        String path = new File(relPath).getAbsolutePath();
        return path;
    }

    public static String getDownloadPath() {
        return getAppPath("C:\\Users\\olahk\\Downloads\\");

    }

    public void cleanupDownloads() {
        for (File f : getDownloadedFiles()) {
            System.out.println("Delete" + f);
            f.delete();
        }
    }

    public File[] getDownloadedFiles() {
        File downloadPath = new File(getDownloadPath());
        File[] files = downloadPath.listFiles();
        System.out.println("getDownloads");
        //LOGGER.debug("Downloaded files: $files")
        return files;

    }
    public boolean isFileInDownloads(String fileName) {
        try {
            Process exec = Runtime.getRuntime().exec(fileName);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
//        waitFor(timeout) {
//            getDownloadedFiles().collect { it.name }.contains(fileName);
//        }
        return false;
    }


    //
    public File getDownloadedFileWithName(String fileName) {
        String path = getDownloadPath() + File.separatorChar + fileName;
        return new File(path);
    }

    public boolean cleanupFileWithName(String fileName) {
        System.out.println("Deleting file:" + fileName);
//        LOGGER.debug("Deleting file: ${fileName}");
        boolean isDeleted = getDownloadedFileWithName(fileName).delete();
        System.out.println("File deleted:" + fileName);
//        LOGGER.debug("File deleted: ${path}");
        return isDeleted;
    }
}
