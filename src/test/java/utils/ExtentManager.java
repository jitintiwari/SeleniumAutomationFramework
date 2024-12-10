package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.CartPage;

public class ExtentManager {

    public static Logger log = LogManager.getLogger(ExtentManager.class);

    public static ExtentReports extentReports;
    public static void setupExtent() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extentReports = new ExtentReports();
        reporter.config().setReportName("Test Automation Framework Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Name", "TAF Task");
        extentReports.setSystemInfo("Author", "Jitin");
    }

    public static void consolidateReport() {
        extentReports.flush();
    }
}
