package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setReportName("QMS Automation Test Report");
            spark.config().setDocumentTitle("Automation Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Your Name");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }
}

