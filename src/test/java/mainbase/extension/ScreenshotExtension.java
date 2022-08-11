package mainbase.extension;

import mainbase.base.TestBase;
import mainbase.utils.CreateScreenshot;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class ScreenshotExtension implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
//        TestBase testbase = (TestBase) context.getRequiredTestInstance();
        TestBase.getDriver().close();
        TestBase.removeDriver();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
//        TestBase testbase = (TestBase) context.getRequiredTestInstance();
//        new CreateScreenshot().createScreenshot(testbase.getDriver(), context.getDisplayName());
        try {
            new CreateScreenshot().createScreenshotWhenFailTest(TestBase.getDriver());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TestBase.getDriver().close();
            TestBase.getDriver().quit();
            TestBase.removeDriver();
        }

    }
}
