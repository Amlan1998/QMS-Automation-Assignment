package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import utils.ExtentManager;

import java.io.File;
import java.nio.file.Files;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getExtentReports();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        utils.ExtentTestManager.setTest(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // Log failure reason
        test.get().fail(result.getThrowable());

        // Get driver safely via getter
        Object testClass = result.getInstance();
        WebDriver driver =
                ((BaseTest) testClass).getDriver();

        try {
            // Take screenshot
            File src =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            File dest =
                    new File("test-output/screenshots/"
                            + result.getMethod().getMethodName() + ".png");

            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());

            // Attach screenshot to report
            test.get().addScreenCaptureFromPath(dest.getPath());

        } catch (Exception e) {
            test.get().warning(
                    "Screenshot capture failed: " + e.getMessage()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
