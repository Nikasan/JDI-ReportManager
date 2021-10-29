package hw8.Utils;

import com.epam.jdi.light.driver.ScreenshotMaker;
import com.epam.reportportal.message.ReportPortalMessage;
import com.epam.reportportal.testng.BaseTestNGListener;
import com.epam.reportportal.testng.ITestNGService;
import com.epam.reportportal.testng.TestNGService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import rp.com.google.common.base.Supplier;
import rp.com.google.common.base.Suppliers;

import java.io.File;
import java.io.IOException;

public class ScreenshotListener extends BaseTestNGListener {
    private static final Logger LOGGER = LogManager.getLogger(ScreenshotListener.class);

    private static final Supplier<ITestNGService> SERVICE = Suppliers.memoize(TestNGService::new);

    public ScreenshotListener() {
        super((ITestNGService) SERVICE.get());
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        this.LOGGER.error("--->>>>>>>>Failure log<<<<<<<<---");

        try {
            ReportPortalMessage message = this.prepareMessage();
            this.LOGGER.error(message);
        } catch (IOException e) {
            e.printStackTrace();
            String message = String.format("ScreenshotListener - onTestFailure: %s ", e.getMessage());
            this.LOGGER.error(message);
        } finally {
            super.onTestFailure(testResult);
        }
    }

    public ReportPortalMessage prepareMessage() throws IOException {
        String rp_message = "Failure screenshot->>:";
        ScreenshotMaker maker = new ScreenshotMaker();
        String screenshot_file_path = maker.takeScreenshot();
        return new ReportPortalMessage(new File(screenshot_file_path), rp_message);
    }
}
