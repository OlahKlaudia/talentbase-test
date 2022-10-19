package mainbase.extension;

import mainbase.testbase.TestBase;
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
        TestBase.getDriver().quit();
        TestBase.removeDriver();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
//        new CreateScreenshot().createScreenshot(testbase.getDriver(), context.getDisplayName());
        try {
            new CreateScreenshot().createScreenshotWhenFailTest(TestBase.getDriver(), context.getTestMethod().get().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TestBase.getDriver().quit();
            TestBase.removeDriver();
        }
    }
}
