package pages.linkspages;

import mainbase.base.TalentbasePage;
import org.openqa.selenium.WebDriver;

public class NotificationPage extends TalentbasePage {
    public NotificationPage(WebDriver driver) {
        super(driver);
    }
    public static final String NOTIFICATIONS = "/notifications";
    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(NOTIFICATIONS);
    }
}
